

Feature: Possible scenarios for login test
 

  @RegistrationNTC
  Scenario: Test NTC user registration flow
    Given Reset Mobile and PAN in credilio
    And Reset mobile and PAN in novio
    Then Launch the novio app
    When Accept the app permission and click Get Started
    And Enter mobile and name
    And Autofill OTP
    Then Enter PAN 
    And Change the Name
    And continue and land on homescreen
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
