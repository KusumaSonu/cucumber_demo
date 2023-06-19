#Author :
#Feature name :
#Number of Scenarios:


Feature: Verify login logut functionality

Scenario: Validate login functionality
Given I will launch the browser 
And I will navigate to the given url
Then I will validate the url
And I will enter the user name in the username field
And I will enter the password in the password field
When I will click on the login button
And I will validate the login page


Scenario: Validate logout functionality

When I will click on three lines options 
And I will click on the logout option
Then I will validate logout is successful or not
 