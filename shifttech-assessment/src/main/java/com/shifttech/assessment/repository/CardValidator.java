package com.shifttech.assessment.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shifttech.assessment.utility.CardInterface;
import com.shifttech.assessment.utility.CardValidationResult;

public class CardValidator {
	 
    public CardValidationResult validateCardDetails(String cardNumber) {
	    try {
			
	        String url = new StringBuilder()
	        		.append(loadProperties().getProperty("lookup.binlist",CardInterface.BIN_LOOKUP_URL))
	        		.append("/")
	        		.append(cardNumber.substring(0,8)).toString();
	        
	        return new ObjectMapper()
	        		.readValue(new RestTemplate().getForObject(url, String.class), CardValidationResult.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
     return null;
   }
    
   public Properties loadProperties() throws Exception {
	    File file = new File("application.properties");
	    Properties prop = new Properties();
	    if(file.exists()) {	
	    	prop.load(new FileReader(file));
		} else {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file not found in the classpath");
			}
		}
	    return prop;
    }
}
