package com.shifttech.assessment.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.shifttech.assessment.utility.*;

public class CardRepository {
	
    private static CardRepository mInstance;
	static {
	    mInstance = new CardRepository();
    }
	  
	private CardRepository() {}
	  
    public static CardRepository getInstance() {
    	return mInstance;
    }
	  
	public AddCardResponse addCard(String cardNumber) {	
		AddCardResponse addCard = new AddCardResponse();
		CreditCard card = creatDefaultCreditCard(cardNumber);
    	
		if(!isNumeric(cardNumber) || (isNumeric(cardNumber) && cardNumber.length() < 13)) {
			addCard.setCard(card);
			addCard.setMessage(CardInterface.INVALID_CREDIT_CARD_FORMART);
			return addCard;
		}
		
    	if(creditCardAlreadyExists(card)){
    		addCard.setCard(card);
    		addCard.setMessage(CardInterface.CARD_EXISTS);
    		return addCard;
    	}
		
		CardValidationResult result = new CardValidator().validateCardDetails(cardNumber);
        if( result!= null && result.getCountry() != null && !result.getCountry().isEmpty())
        {
        	card.setCountryOfOrigin(result.getCountry().get("name"));
        	
        	if(result.getScheme() != null)
        		card.setCardType(result.getScheme().toUpperCase());
        	
        	if(isFromBannedCountry(result.getCountry().get("alpha2"))) {
        		addCard.setMessage(CardInterface.BANNED_COUNTRY_ERROR);
        		addCard.setCard(card);
        		return addCard;
        	}

        	if(saveCard(card)) {
        		card.setStatus(CardInterface.PROCESSED);
        		addCard.setMessage(CardInterface.PROCESSED_SUCCESS);
        	} else {
        		addCard.setMessage(CardInterface.PROCESSING_ERROR);
        	}
        	
        	addCard.setCard(card);
        } else {
    		addCard.setMessage(CardInterface.CARD_VALIDATION_ERROR);
        }
      return addCard;
	}
	
	private CreditCard creatDefaultCreditCard(String cardNumber) {
		CreditCard card = new CreditCard();
		card.setCardNumber(cardNumber);
		card.setStatus(CardInterface.UNPROCESSED);
    	card.setCardType(CardInterface.UNKNOWN);
    	card.setCountryOfOrigin(CardInterface.UNKNOWN);
    	return card;
	}
	
	public CardListResponse allCards(){
		CardListResponse response = new CardListResponse();
		response.setCards(new ArrayList<CreditCard>());
		Collection<CreditCard> cards = new ArrayList<CreditCard>();
		boolean errorOccured = false;
		
		
		if(!isEmptyCreditCardList()) {
			try {	
				CSVReader reader = new CSVReader(new FileReader(CardInterface.CARDS_CSV));
				String[] line = null;
		
				while ((line = reader.readNext()) != null) {
					CreditCard card = new CreditCard();
					card.setCardNumber(line[0]);
					card.setCardType(line[1]);
					card.setCountryOfOrigin(line[2]);
					card.setStatus(line[3]);
					cards.add(card);
				}
				reader.close();
				response.setCards(cards);
		   } catch (Exception ex) {
			   errorOccured = true;
			   response.setMessage(ex.getMessage());
		   }
	   }
		
	   if(cards.isEmpty() && !errorOccured)
		   response.setMessage(CardInterface.EMPTY_CARLIST);
	   
	   return response;
	}
	
	public List<AddCardResponse> processCards(List<String> creditCardNumbers){
		List<AddCardResponse> responses = new ArrayList<AddCardResponse>();
		for(String cardNumber : creditCardNumbers) 
			responses.add(addCard(cardNumber));
		
		return responses;
	}
	
	private boolean saveCard(CreditCard card) {
		try {
		    CSVWriter writer = new CSVWriter(new FileWriter(CardInterface.CARDS_CSV, true));
    		card.setStatus(CardInterface.PROCESSED);
		    StringBuilder sb = 
    		 new StringBuilder()
    		 .append(card.getCardNumber())
    		 .append(",")
    		 .append(card.getCardType())
    		 .append(",")
    		 .append(card.getCountryOfOrigin())
    		 .append(",")
    		 .append(card.getStatus());
		     writer.writeNext(sb.toString().split(","));
		     writer.close();
		     return true;
		} catch(Exception ex) {
			return false;	
		}
	}
	
	private boolean isFromBannedCountry(String country) {
		try
		{
			return new CardValidator().loadProperties()
					.getProperty("banned.countries","")
					.toLowerCase()
					.contains(country.toLowerCase());
		} catch (Exception ex) { }
		return false;
	}
	
	private boolean creditCardAlreadyExists(CreditCard card) {
		try {	
			
			if(isEmptyCreditCardList()) 
				return false;

			CSVReader reader = new CSVReader(new FileReader(CardInterface.CARDS_CSV));
			String[] line = null;
			boolean found = false;
			while ((line = reader.readNext()) != null) {
				if(line[0].trim().equalsIgnoreCase(card.getCardNumber().trim())) {
					card.setCardType(line[1]);
					card.setCountryOfOrigin(line[2]);
					found = true;
					break;
				}
			}
			reader.close();
			return found;
	   } catch (Exception ex) {
		   return false;
	   }
	}
	
	private boolean isEmptyCreditCardList() {
		try {
		java.io.File file = new java.io.File(CardInterface.CARDS_CSV);
		
		if(file.exists()) {
			return false;
		}
		return true;
	   } catch (Exception ex) {
		   return true;
	   }
	}
	 
	private boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
	}
}