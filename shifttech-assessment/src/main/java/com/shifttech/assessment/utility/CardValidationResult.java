package com.shifttech.assessment.utility;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardValidationResult {
	Map<String,String> number;
	Map<String,String> country;
	String scheme;

	public Map<String, String> getNumber() {
		return number;
	}
	public void setNumber(Map<String, String> number) {
		this.number = number;
	}
	public Map<String, String> getCountry() {
		return country;
	}
	public void setCountry(Map<String, String> country) {
		this.country = country;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
}