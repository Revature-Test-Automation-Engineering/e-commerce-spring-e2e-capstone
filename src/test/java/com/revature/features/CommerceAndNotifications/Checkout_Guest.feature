Feature: Guest Checkout

  Scenario: Guest checks out the cart
    Given guest is not logged in
    Given the guest is on the homepage
    Then the guest adds one shrek croc to his cart
    Then the guest goes to the checkout page
    When guest clicks on the Checkout Now button
    And guest fills in shipping address and clicks Next button
    Then the guest should be on the select payment page
    Then the guest selects payment method
    And clicks submit payment
    Then the guest goes to the review order page
    When the guest clicks the place order button
    Then the page gives a message of success for placing order

    # Fail: no way for a guest to add payment method