
# This Day1 12/01/2024 
# checking the login functionality for the novio app.

@Onboarding
Feature: feature to test novio login

  Scenario: Check login is successfully with valid credential
    Given User launch the app
    When user enter mobile number and name
    And clicks on submit button
    And Submit the OTP
    And submit the pan number
    Then user is navigating to novio homepage	
