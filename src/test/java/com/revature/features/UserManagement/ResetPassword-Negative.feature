Feature: Reset Password - Negative
  Scenario Outline: User resets password with invalid password
    Given the user is on the login page
    When  the user clicks on the reset your password link
    Then  the user should be on the forgot password page
    When  the user enters their email address into the email address text input
    And   the user clicks on the send reset password link button
    Then  a message should appear containing "A link to reset your password has been sent"
    When  the user goes to their email and clicks on the sent link
    Then  the user should be on the reset password page
    When  the user enters "<password>" into the new password input
    And   the user clicks on the reset password button
    Then  the user should not be on the login page
    When  the user enters their new credentials into the form and clicks on the sign in button
    Then  the user should not be on the home page after resetting their password

    Examples:
      | password   |
      |   Te123!   |
      |TESTING123! |
      |testing123! |
      |  Testing!  |
      | Testing123 |