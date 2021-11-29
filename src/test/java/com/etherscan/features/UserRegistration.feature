Feature: This feature is to test user registration functionality


  Background: User is on registration page
	Given user is on user registration page

  Scenario Outline: validate error message for invalid user name    
    When user provides "<invalid_user_name>" as user name
    Then user should see "<error_message>" message
    Examples:
    	|invalid_user_name|error_message|
    	|abc|Username is invalid.|
    	|abc@123|Username is invalid.|
    	
    	
   Scenario: validate that user name is mandatory    
    When user creates account
    Then user should see "Username is invalid." message

    	
  
  Scenario Outline: validate error message for invalid email address    
    When user provides "<invalid_email_address>" as email address
    Then user should see "<error_message>" message
    Examples:
    	|invalid_email_address|error_message|
    	|abc				  |Please enter a valid email address.|
    	|a bc@gmail.com		  |Please enter a valid email address.|
    	
  Scenario: validate that email address is mandatory
    When user provides "abcdefgh" as user name
    When user creates account
    Then user should see "Please enter a valid email address." message

 
  	
  Scenario: validate error message for invalid password
    When user provides "Abc@" as password
    Then user should see "Your password must be at least 5 characters long." message
    
    
  Scenario: validate that password is mandatory
    When user provides "abcdefgh" as user name
    And user provides "Kavi@123.com" as email address
     And user creates account
    Then user should see "Your password must be at least 5 characters long." message
   	
   
  Scenario: validate error message when password is confirmed wrongly
    When user provides "Abc@123" as password
    And user provides "Abc@1234" as confirm password
    Then user should see "Password does not match, please check again." message

  
   Scenario: validate that confirm password is mandatory
    When user provides "abcdefgh" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user creates account
    Then user should see "Your password must be at least 5 characters long." message  
  
  Scenario: validate that user is not able to create account without accepting terms and conditions
    When user provides "Kavi123" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user provides "Abcdhe" as confirm password
    And user creates account
    Then user should see "Please accept our Terms and Conditions." message

    
   
  Scenario: validate that user is not able to create account without selecting captcha
    When user provides "Kavi123" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user provides "Abcdhe" as confirm password
    And user accepts terms and contions
    And user creates account
    Then user should see "Error! Invalid captcha response.Please Try Again" message

    

  Scenario: validate that user is able to create account successfully by subscribing to newsletter
    When user provides "Kavi123" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user provides "Abcdhe" as confirm password
    And user accepts terms and contions
    And user subscribs to newsletter
    And user selects captcha    
    And user creates account
	Then user should see "Your account registration has been submitted and is pending email verification " message
	
	
  Scenario: validate that user is able to create account successfully without subscribing to newsletter
    When user provides "Kavi123" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user provides "Abcdhe" as confirm password
    And user accepts terms and contions
    And user selects captcha    
    And user creates account
	Then user should see "Your account registration has been submitted and is pending email verification " message
	
	
	
  Scenario: validate that user is not able to register with existing user name
    When user provides "abcd1" as user name
    And user provides "Kavi@123.com" as email address
    And user provides "Abcdhe" as password
    And user provides "Abcdhe" as confirm password
    And user accepts terms and contions
    And user subscribs to newsletter
    And user selects captcha    
    And user creates account
    Then user should see "Sorry! The username you entered is already in use." message
   
