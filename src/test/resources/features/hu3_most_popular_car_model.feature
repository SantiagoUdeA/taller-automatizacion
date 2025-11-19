Feature: HU 3 - Select the most popular car
  As a User
  I want to select the most popular car
  So that I can see the information and ratings of the most popular car on the site

  Scenario: The user selects the most popular car
    Given that I am on the home page
    When I select the most popular car
    Then the system shows me the car specifications
    And the number of votes
