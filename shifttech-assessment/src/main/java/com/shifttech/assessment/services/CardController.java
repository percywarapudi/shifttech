package com.shifttech.assessment.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shifttech.assessment.service.CardService;
import com.shifttech.assessment.utility.*;

@RestController
public class CardController {

	@RequestMapping(value="/addcard/{card_number}", method = RequestMethod.POST)
	public AddCardResponse addCard(@PathVariable(value="card_number") String cardNumber) {
		return CardService.addCard(cardNumber);
	}

	@RequestMapping("/allcards")
	public CardListResponse getAllCards() {
		return CardService.allCards();
	}
	
	@RequestMapping(value="/bulkprocesscards", method = RequestMethod.POST)
	public List<AddCardResponse> processCards(@RequestParam(value="credit_cards") List<String> creditCards) {
		return CardService.processCards(creditCards);
	} 
}