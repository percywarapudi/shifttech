Please read this file to undestand how the assessment works
===========================

1. <b>Application details</b><br/>
    The application is a SpringBoot Application with an embedded tomcat server, so no need to deploy on standalone server. 
    To start the application execute the following using the options
     
    Option A: Use pre-compiled jar<br/>
    <b>java -jar {basePath}/shifttech-assessment/target/shifttech-assessment-0.0.1-SNAPSHOT.jar</b><br/>
    
    Option B: Compile the project with Maven(maven must be installed on your machine)<br/>
    Import the project you IDE of choice(IntelliJ,Eclipse, STS)<br/>
    Build as Maven project using provided functionality in the IDE<br/>
    Then<br/>
        <b>java -jar {basePath}/shifttech-assessment/target/shifttech-assessment-0.0.1-SNAPSHOT.jar</b><br/>

    
    Option C: Build the project using command line(maven must be installed on your machine)<br/>
        a. Navigate to base path of the project after cloning it<br/>
        b. run command mvn clean install<br/>
        c. <b>java -jar {basePath}/shifttech-assessment/target/shifttech-assessment-0.0.1-SNAPSHOT.jar</b><br/>

    Once the application has started(should take no more than 5secs), you are ready to make requests using Postman

2. <b>Banned countries</b><br/>
    The list of banned countries is saved as a comma separated value within <b>application.properties</b> file. 
    The country code of these countries are used instead of the full/official names.
    The reason being because the country code is more consitent compared to full/official names that could potentially be misplelled, 
    different variations of the name used e.g South Africa vs Republic of South Africa.
    
    A country codes file (<b>country_codes.csv</b>) is provided within the project for references
   
3. <b>Credit card validation service</b><br/>
    I'm using an API called binlist(https://lookup.binlist.net) to validate the provided credit card number details. 
    The API returns the country of origin, issuing bank, scheme name(i.e VISA,MASTER CARD etc) information.

4. <b>Postman and testing the endpoints</b><br/>
    In order to test the API endpoints, a Postman Collection with a link(https://www.getpostman.com/collections/29563129afcc2d485208) can be used. This link is made public and should be accessible
