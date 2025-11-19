Feature: HU 2 - Login
  As a User
  I want to log into the system
  So that I can access the application

  Scenario: The user logs in successfully
    Given That I'm logged out
    And I have a registered account with name "Santiago"
    And I am on the login page
    When I enter my login data
    Then the system shows me a welcome message "Hi, Santiago"

  Scenario: The user enters an invalid username or password
    Given That I'm logged out
    And I am on the login page
    When I enter an invalid username or password
    Then the system shows me an error message "Invalid username/password"
