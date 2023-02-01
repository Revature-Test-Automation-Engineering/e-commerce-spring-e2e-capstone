Feature: User can manage their profile
  Background:
    Given User is logged in and on their profile page


  Scenario Outline: User updates their profile with invalid names
    When User types "<firstname>" in the First Name field
    And User types "<lastname>" in the Last Name field
    And User types "<password>" in the Password field
    And User clicks Update button
    Then User should not get message for successful update

    Examples:
      |   firstname   | |   lastname   | |   password   |
      |   123         | |   Morgan     | |   Abc12345!  |
      |   John        | |   456       | |   Abc12345!  |


  Scenario Outline: User updates their profile with invalid password
    When User types "<firstname>" in the First Name field
    And User types "<lastname>" in the Last Name field
    And User types "<password>" in the Password field
    And User clicks Update button
    Then User should not get message for successful update

    Examples:
      |   firstname    | |   lastname   | |   password   |
      |   Profile      | |   Test       | |    12345     |
      |   Profile      | |   Test       | |              |

  Scenario Outline: User updates their profile with valid information
    When User types "<firstname>" in the First Name field
    And User types "<lastname>" in the Last Name field
    And User types "<password>" in the Password field
    And User clicks Update button
    Then User should get message for successful update

    Examples:
      |   firstname     | |   lastname       | |   password      |
      |   Profile       | |   Test           | |   ProfileTest!  |


  Scenario Outline: User adds payment method with valid card details
    When User types "<cardNumber>" in the Card Number field
    When User types "<expiryDate>" in the Expiry Date field
    When User types "<ccv>" in the CCV field
    When User clicks Add Payment button
    Then User should get a message that payment method is added successfully

    Examples:
      |   cardNumber          |  |   expiryDate   |  |    ccv   |
      |  1234567812345678     |  |  05/23/2024    |  |    654   |

  Scenario Outline: User adds payment method with invalid card details
    When User types "<cardNumber>" in the Card Number field
    When User types "<expiryDate>" in the Expiry Date field
    When User types "<ccv>" in the CCV field
    When User clicks Add Payment button
    Then User should not get a message that payment method is added successfully

    Examples:
      |   cardNumber      |  |   expiryDate   |  |   ccv   |
      |  ABC              |  |  05/23/2024    |  |   123   |
      |  1234567812345678 |  |  01/01/1991    |  |   123   |
      |  1234567812345678 |  |  05/23/2024    |  |   ABC   |


  Scenario: User deletes payment method
    When User clicks Delete button for a card
    Then The user should get a message that card have be removed

  Scenario: User deactivates the account
    When User types deactivate in the confirmation field
    """
    deactivate
    """
    Then Deactivate button becomes enabled
    When User clicks DEACTIVATE button
    Then User will be logged out and can no longer log in again

