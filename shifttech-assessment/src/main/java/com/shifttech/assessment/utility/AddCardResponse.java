package com.shifttech.assessment.utility;

public class AddCardResponse {
	CreditCard card;
	String message;
	boolean cardProcessed;
	
	public CreditCard getCard() {
		return card;
	}
	
	public void setCard(CreditCard card) {
		this.card = card;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}