Please read this file to undestand how the assesment works
==========================================================

1. Application details - 
    The application is a SpringBoot Application with an embedded tomcat server, so no need to deploy on standalone server. 
    To start the application execute the following command

    java -jar 

    Once the application has started(takes no more than 5secs), you are ready to make requests using Postman

2. Banned Countries - 
    The list of banned countries is saved as a comma separated value within application.properties file. 
    The country code of these countries are used instead of the full/official names.
    The reason being because the country code is more consitent compared to full/official names that could potentially be misplelled, 
    different variations of the name used e.g South Africa vs Republic of South Africa.
    
    A country codes file (country_codes.csv) is provided within the project for references
   
3. Credit Card validation service - 
    I'm using an API called binlist(https://lookup.binlist.net) to validate the provided credit card number details. 
    The API returns the country of origin, issuing bank, scheme name(i.e VISA,MASTER CARD etc) information.

4. Postman and testing the endpoints - 
    In order to test the API endpoints, a Postman Collection with a link(https://www.getpostman.com/collections/29563129afcc2d485208) can be used. This link is made public and should be accessible
