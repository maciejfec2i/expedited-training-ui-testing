@RemovingItemsFromCartTests
Feature: When removing items from the cart

  @RemovingItemsFromCartTest1
  Scenario Outline: The items should not be displayed in the cart when removed through the 'Your Cart' page
    Given A Standard User has the following items in the cart: <items-to-add>
    And they are on the Swag Labs Cart page
    When they remove the following items from the cart: <items-to-remove>
    Then the following items should no longer be in the cart: <items-to-remove>

    Examples:
      | items-to-add                                                                 | items-to-remove                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                | Sauce Labs Onesie                               |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt | Sauce Labs Bike Light, Sauce Labs Fleece Jacket |