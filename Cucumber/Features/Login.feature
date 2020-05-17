#Feature: Login Action
#@tag1
#Scenario: Successful Login with Valid Credentials
#	Given Launch Browser
#	When Navigate to Application
#	And User enters UserName
#	And User enter Password	
#	And User select value from language dropdown
#	And User click on login button
#	Then Message displayed Login Successfully

#@tag2
#Scenario: Successful LogOut
#	When User LogOut from the Application
#	Then Message displayed LogOut Successfully
	
Feature: Login Action By Data Driven

	Scenario:
	Given Launch Browser
	
  Scenario Outline: Login with Different Credentials
    When Navigate to Application
    And User enters UserName <username> and <password>    
    And User click on login button
    Then Error Message <expected>
    Examples: 
      | username | password | expected                                        |
      | abc      | abc      | You must specify a valid username and password. |
      |    54646 | hkjhh    | You must specify a valid username and password. |
      | admin    | admin    | admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM                             |
		
	
	