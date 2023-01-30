Feature: Notifications - Negative

  # The notification is supposed to occur after you complete a purchase
  # not sure if you'll have to simulate going through that process
  # within the step implementation

  Background:
    Given The user is on the cart page

  Scenario: User receives an alert when a transaction is unsuccessful
    Given The cart is empty
    When The user clicks the Submit Payment button
    And The user clicks the place order button
    Then The user should receive an alert saying ad