Feature: User authentication

  Users must authenticate to access the Billing and Payments module.

  Scenario: User gains access with valid credentials
    Given the user has valid authentication details
    When they attempt to sign in
    Then they should gain access to the Billing and Payments module

  Scenario: User is informed when authentication fails
    Given the user provides invalid authentication details
    When they attempt to sign in
    Then they should be informed that the authentication details are incorrect
