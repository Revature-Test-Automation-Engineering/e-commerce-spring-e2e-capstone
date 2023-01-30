Feature: User Deactivate his own account

  Scenario: Deactivate your account
    Given User logged into the home page
    When User clicks profile button
    Then User welcome to his dashboard
    When User put deactivate in the input field
    """
    deactivate
    """
    Then Deactivate button becomes enabled
    When User clicks DEACTIVATE button
    Then User will be logged out to login page