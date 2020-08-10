package com.shifttech.assessment.utility;

import java.util.Collection;

public class CardListResponse {
	Collection<CreditCard> cards;
	String message;
	
	public Collection<CreditCard> getCards() {
		return cards;
	}
	
	public void setCards(Collection<CreditCard> cards) {
		this.cards = cards;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
