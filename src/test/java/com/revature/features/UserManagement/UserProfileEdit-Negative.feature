Feature: User input invalid data to edit his own profile

  Background:
    Given User logged into the home page
  Scenario Outline: User update your profile(Negative Testing)
    When User clicks profile button
    Then User welcome to his dashboard
    When User puts his new "<firstname>" in the input field
    When User puts his new "<lastname>" in the input field
    When User puts his new "<password>" in the input field
    When User clicks update button
    Then User gets appropriate message

    Examples:
    |   firstname   | |   lastname   | |   password   |
    |               | |              | |      5       |
    |    #          | |       *      | |      #       |
    |   546         | |     &&       | |     ""       |
    |   a           | |     c        | |              |
    |               | |              | | 1234Pa56*    |