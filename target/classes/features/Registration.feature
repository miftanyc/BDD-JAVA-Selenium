Feature: This test will ensure resgistration functionality


Scenario: Varify Registering a user providing all mandatory field value
Given user has landed to registraion page
When User will provide following details in the required field
|firstName			|Mifta								|
|lastName				|Chowdhury						|
|email					|Generated_Email			|
|telephone			|1234567890						|
|password				|123456								|
|Confirm pasword|123456								|
And user will click policy check box
And user will click continue button
Then user will be resgistered as new user showing Account success message 


Scenario: Varify Registering a user providing all field value
Given user has landed to registraion page
When User will provide following details in the required field
|firstName			|Mifta								|
|lastName				|Chowdhury						|
|email					|Generated_Email			|
|telephone			|1234567890						|
|password				|123456								|
|Confirm pasword|123456								|
And user will click policy check box
And user will click yes for newslatter check box
And user will click continue button
Then user will be resgistered as new user showing Account success message


Scenario: Verify Registration functionality providing Existing email address
Given user has landed to registraion page
When User will provide following details in the required field
|firstName			|Mifta								|
|lastName				|Chowdhury						|
|email					|valid_Email					|
|telephone			|1234567890						|
|password				|123456								|
|Confirm pasword|123456								|
And user will click policy check box
And user will click continue button
Then user will get a proper warnign about duplicate email


Scenario: Verify Registration functionality without providing any detail value
Given user has landed to registraion page
When User dont enter any details into field 
And user will click continue button
Then user will get a proper warnign about every mandatory field

