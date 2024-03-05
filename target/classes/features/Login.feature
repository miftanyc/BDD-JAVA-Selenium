Feature: Login functionality

Scenario Outline: Login with valid credentials
  Given User will be navigated to the login page
  When user will provide a valid Email address <userName> in the Email address field
  And User will provide a valid Password <password> in the password field
  And click on the Login button
  Then user will be able to successfully log in to the account page
  
  Examples:
  |userName											|password			|
  |miftanyc+qa@gmail.com				|123456				|
  |miftanyc+qa1@gmail.com				|123456				|
  |miftanyc+qa2@gmail.com				|123456				|
  |miftanyc+qa3@gmail.com				|123456				|
  

Scenario: Login with invalid credentials
  Given User will be navigated to the login page
  When user will provide an invalid Email address in the Email address field
  And User will provide an invalid Password "123456789" in the password field
  And click on the Login button
  Then user will not be able to log in and get a proper warning message about credential mismatch

Scenario: Login with an invalid Password
  Given User will be navigated to the login page
  When user will provide a valid Email address "miftanyc+qa@gmail.com" in the Email address field
  And User will provide an invalid Password "123456789" in the password field
  And click on the Login button
  Then user will not be able to log in and get a proper warning message about credential mismatch

Scenario: Login with an invalid Email address
  Given User will be navigated to the login page
  When user will provide an invalid Email address in the Email address field
  And User will provide a valid Password "123456" in the password field
  And click on the Login button
  Then user will not be able to log in and get a proper warning message about credential mismatch

Scenario: Login without providing any credentials
  Given User will be navigated to the login page
  When user will leave the Email address field blank
  And User will leave the Password field blank
  And click on the Login button
  Then user will not be able to log in and get a proper warning message about credential mismatch
