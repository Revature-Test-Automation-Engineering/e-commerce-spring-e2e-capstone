Feature: Notifications - Positive

  # The notification is supposed to occur after you complete a purchase
  # not sure if you'll have to simulate going through that process
  # within the step implementation

  Background:
    Given The user is on the cart page

  Scenario: User receives notification when a transaction has occurred successfully
    Given The cart is not empty
    When The user clicks the Submit Payment button
    And The user clicks the Place Order button
    Then The user should receive a notification about the transaction