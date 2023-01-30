Feature: User inputs invalid payment details

  Scenario Outline: User adds payment method (Negative Testing)
    Given User logged into the home page
    When User clicks profile button
    Then User welcome to his dashboard
    When User put "<cardNumber>" in the input field
    When User put cards "<expiryDate>" in the input field
    When User put "<ccv>" in the input field
    When User clicks add payment button
    Then A mandatory appropriate input message should appear for each field
    Examples:
      |   cardNumber      |  |   expiryDate   |  |   ccv   |
      |  1                |  |  05/23/2024    |  |    6    |
      |  0                |  |  05/01/2026    |  |         |
      |                   |  |                |  |    025  |
      | 541223657894      |  |  01/28/2022    |  |   102   |
      | fghb1235          |  |  08/05/2030    |  |   852   |
      | 302132148965      |  |  06/00/0000    |  |   707   |
      | 302132148965      |  |  00/01/2025    |  |   a*b   |
      | 302132148965      |  |  20/20/0001    |  |   a*b   |
