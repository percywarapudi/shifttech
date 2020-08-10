package com.shifttech.assessment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.jayway.restassured.RestAssured.given;

@SpringBootTest
public class ShifttechAssessmentApplicationTests 
	extends BaseTester {
  
  /*@Test
  public void getAllCards() {
    System.out.println("GetAllCards :"+ given().get("/allcards").asString());
  }
  
  @Test
  public void addCard() {
    System.out.println("testAddCard :"+ given().pathParam("card_number", "5414122474289585").post("/addcard/{card_number}").asString());
  }
  
  @Test
  public void bulkProcessCards() {
    System.out.println("testAddCard :"+ given().pathParam("card_number", "5414122474289585").post("/addcard/{card_number}").asString());
  }*/
  
}