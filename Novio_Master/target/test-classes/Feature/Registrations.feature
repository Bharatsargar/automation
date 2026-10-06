Feature: Complete registration flow journey

	Background:
	Given Reset the mobile and pan in novio
    And Reset the mobile and pan in credilio

  @reg
  Scenario: Register the NTC user
    
    When launch the app
    And accept the permission and getstart
    And submit the mobile and name
    Then submit the otp and pan
    And submit the pan
    And user land over the homescreen

@reg1
  Scenario: Register the Existing user in credilio
    #Given Reset the mobile and pan in novio
    #And Reset the mobile and pan in credilio
    And Store the bureau in credilio
    And connecting to db and get details
    #When launch the app
    #And accept the permission and getstart
    #And submit the mobile and name
    #Then submit the otp
    #And user land over the homescreen
