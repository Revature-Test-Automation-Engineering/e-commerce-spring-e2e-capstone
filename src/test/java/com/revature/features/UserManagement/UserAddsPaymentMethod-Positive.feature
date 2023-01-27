Feature: User adds right payment details to add new payment method

  Scenario Outline: User adds payment method (Positive Testing)
    Given User logged into the home page
    When User clicks profile button
    Then User welcome to his dashboard
    When User put "<cardNumber>" in the input field
    When User put cards "<expiryDate>" in the input field
    When User put "<ccv>" in the input field
    When User clicks add payment button
    Then A message alerts You've successfully added your payment method!
    Examples:
      |   cardNumber      |  |   expiryDate   |  |   ccv   |
      |  123456780123     |  |  05/23/2024    |  |    654  |