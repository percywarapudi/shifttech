package com.shifttech.assessment.service;

import java.util.List;

import com.shifttech.assessment.repository.CardRepository;
import com.shifttech.assessment.utility.AddCardResponse;
import com.shifttech.assessment.utility.CardListResponse;

public class CardService {	
	public static AddCardResponse addCard(String cardNumber) {
		return CardRepository.getInstance().addCard(cardNumber);
	}
	
	public static CardListResponse allCards(){
		return CardRepository.getInstance().allCards();
	}
	
	public static List<AddCardResponse> processCards(List<String> creditCards){
		return CardRepository.getInstance().processCards(creditCards);
	}
}
