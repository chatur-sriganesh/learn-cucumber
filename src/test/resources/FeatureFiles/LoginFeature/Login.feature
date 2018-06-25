#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@LoginFeature
Feature: Title of your feature
  I want to use this template for my feature file

  @signin
  Scenario Outline: Title of your scenario
    Given I  open the "chrome" browser
    And I open application
    # And I open application "http://www.google.com"
    And I click "signin" button on "Homepage" screen
    And I enter "<username>" value in "username" field on "Login" screen
    And I enter "<password>" value in "password" field on "Login" screen
    And I click "loginbutton" button on "Login" screen
    Then I verify "welcomelabel" on "Adminpage" is "<WelcomeMessage>"
   	Examples: 
      | username  | password | WelcomeMessage					 |
      | admin 		| admin 	 | Hello Admin User				 |
      | jsmith		| Demo1234 | Hello John Smith  	  	 |
