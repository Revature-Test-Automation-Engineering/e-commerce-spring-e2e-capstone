Feature: Reset Password - Positive

  Scenario: User resets password with correct credentials
    Given the user is on the login page
    When  the user clicks on the reset your password link
    Then  the user should be on the forgot password page
    When  the user enters their email address into the email address text input
    And   the user clicks on the send reset password link button
    Then  a message should appear containing "A link to reset your password has been sent"
    When  the user goes to their email
    Then  the user should see an unread email with the title Reset your Congo Password
    When  the user clicks on the email
    And   the user clicks on the provided link
    Then  the user should be on the reset password page
    When  the user enters their new password into the new password input
    And   the user clicks on the reset password button
    Then  the user should be on the login page
    When  the user enters their new credentials into the form and clicks on the sign in button
    Then  the user should be on the home page after resetting their password


    # The password must have uppercase letters, lowercase letters,
    # numbers and special characters with a length of at least 8 characters