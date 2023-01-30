Feature: User searching for the products

  Background:
    Given User logged into the home page

  Scenario: Search products available
    When User put product name in the input box
    """
    apple
    """
    When User clicks search button
    Then User can view the product details
    When User clicks the cart
    Then The cart should be added one

  Scenario Outline:  Search products not available
    When User put "<product name>" in the input box
    When User clicks search button
    Then User should see no products

    Examples:
      | product name |
      | Tomato       |
      | @@@@###      |
      | Olive Oil    |
  Scenario Outline: Search product inputs clear
    When User put "<product name>" in the input box
    When User clicks X button
    Then Search input box should be cleared
#    Hello

    Examples:
      | product name |
      | Shoes        |


