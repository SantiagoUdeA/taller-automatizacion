Feature: HU 4 - Submit a car rating

  Scenario: The user submits a rating for a car model
    Given that I am authenticated in the application
    And I am on the page of a car model
    When I submit a vote with the comment "Good car!"
    Then the system shows me a confirmation message "Thank you for your vote!"

  Scenario: The user sees the comment they submitted
    Given that I have submitted a vote with the comment "Good car!"
    When I am on the page of a car model
    Then I can see my comment "Good car!"