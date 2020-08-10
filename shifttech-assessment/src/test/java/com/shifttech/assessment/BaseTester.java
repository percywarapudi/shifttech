package com.shifttech.assessment;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class BaseTester {
  @BeforeClass
  public static void setup() {
      RestAssured.port = Integer.valueOf(8080);
      RestAssured.baseURI = "http://localhost";
  }
}