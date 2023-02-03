Feature: Display Products
  Scenario: guest can see a list of products
    Given the guest is on the guest page
    Then  the guest can see a list of products

  Scenario Outline: user or admin can see a list of products
    When user clicks sign in button
    When the user logs in with the email "<email>" and the password "<password>"
    Then  the user should be on the home page
    Then user can see number of links in the page
    And   the user should see a list of products
    When the user clicks logout link
    Then user is in the sign in page


    Examples:
    | email          |          | password   |
    | jack@gmail.com |          | Pass1234#  |
    | hello@gmail.com |         | 987456rM#   |


