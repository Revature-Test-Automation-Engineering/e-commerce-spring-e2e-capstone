Feature: User delete his own payment method

  Scenario: User delete payment method
    Given User logged into the home page
    When User clicks profile button
    Then User welcome to his dashboard
    When User clicks delete payment method he added earlier
    Then The payment method should be removed