package com.shifttech.assessment.utility;

public interface CardInterface {
  public static final String EMPTY_CARLIST = "There are no credit cards stored"; 
  public static final String CARDS_CSV = "cards.csv"; 
  public static final String BANNED_COUNTRY_ERROR = "The provided credit card cannot be processed, banned country of origin flagged"; 
  public static final String PROCESSING_ERROR = "An error occurred while processing, card was not saved";
  public static final String CARD_VALIDATION_ERROR = "An error occurred while validating card details";
  public static final String CARD_EXISTS = "The provided card already exists";
  public static final String PROCESSED_SUCCESS = "Credit card processing was successful, card is saved";
  public static final String INVALID_CREDIT_CARD_FORMART = "The provided credit card number is not a valid format";
  public static final String BIN_LOOKUP_URL = "https://lookup.binlist.net";
  public static final String UNPROCESSED = "UNPROCESSED";
  public static final String PROCESSED = "PROCESSED";
  public static final String UNKNOWN = "UNKNOWN";
}