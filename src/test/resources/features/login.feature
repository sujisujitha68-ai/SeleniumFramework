Feature: Login functionality
Scenario: Login with valid credentials
  Given user is on login page
  When user enters username and password
  Then user should navigate to dashboard