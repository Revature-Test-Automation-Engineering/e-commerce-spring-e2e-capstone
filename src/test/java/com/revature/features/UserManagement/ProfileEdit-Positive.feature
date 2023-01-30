Feature: User can update his profile and user can change his payment details and user can deactivate his account
  Background:
    Given User logged into the home page

  Scenario Outline: User update your profile(Positive Testing)
    When User clicks profile button
    Then User welcome to his dashboard
    When User puts his new "<firstname>" in the input field
    When User puts his new "<lastname>" in the input field
    When User puts his new "<password>" in the input field
    When User clicks update button
    Then User gets message You've successfully updated your profile
    Examples:
      |   firstname   | |   lastname   | |   password   |
      |      Raj      | |      Soy     | |  4569Pass!   |












