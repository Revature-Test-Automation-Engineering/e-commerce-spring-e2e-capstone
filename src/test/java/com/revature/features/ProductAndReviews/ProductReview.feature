Feature: Product Review

  Scenario Outline: (maximized)User reviews product
    Given User logged in with username "<username>"  and password "<password>"
    When User types product name in the search box
    When User clicks the appropriate product
    Then User is on the product review page
    When User clicks page enlarge arrow mark
    Then Page maximizes its size
    When User clicks "<rating>" stars for their rating
    When User inputs comment in the product review box "<comment>"
    When User clicks submit review button
    Then User should be able to see their rating and comment below the input field "<comment>"

    Examples:
      |       username        |password|rating |                comment                |
      |mickeymouse@example.com|pass123 |   3   |             It works fine.            |
      #|wirtualtm@example.com  |pass123 |   4   |           I really like it!           |

  Scenario Outline: (minimized)User reviews product
    Given User logged in with username "<username>"  and password "<password>"
    When User types product name in the search box
    When User clicks the appropriate product
    Then User is on the product review page
    When User clicks "<rating>" stars for their rating
    When User inputs comment in the product review box "<comment>"
    When User clicks submit review button
    Then User should be able to see their rating and comment below "<comment>"

    Examples:
      |       username        |password|rating |                comment                   |
      |mickeymouse@example.com|pass123 |   3   |             It works fine. 2             |
      #|wirtualtm@example.com  |pass123 |   4   |           I really like it! 2            |


  Scenario Outline: User enters blank review
    Given User logged in with username "<username>"  and password "<password>"
    When User types product name in the search box
    When User clicks the appropriate product
    Then User is on the product review page
    When User clicks "<rating>" stars for their rating
    When User clicks submit review button
    Then User will not be able to see their review

    Examples:
      |       username        |password|rating |
      |mickeymouse@example.com|pass123 |   3   |
      #|wirtualtm@example.com  |pass123 |   4   |


