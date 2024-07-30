@RemoveFromCartTests
Feature: When removing item(s) from the cart

  @RemoveFromCartTest01
  Scenario Outline: the 'Add to cart' button on the item product card on the 'Products' page should be displayed
    Given A Standard User is logged in and they have the following items in the cart: <item>
    And they are on the Swag Labs Inventory page
    When they remove the following items from the cart: <item>
    Then the Add to cart button should be displayed for the following items: <item>

    Examples:
      | item                     |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |

  @RemoveFromCartTest02
  Scenario Outline: the cart badge should display the correct number of items
    Given A Standard User is logged in and they have the following items in the cart: <items-to-add>
    And they are on the Swag Labs Cart page
    When they remove the following items from the cart: <items-to-remove>
    Then the cart badge should display that the cart contains <expected-num-of-items> items

    Examples:
      | items-to-add                                                                       | items-to-remove                                 | expected-num-of-items |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt (Red) | Sauce Labs Bike Light, Sauce Labs Fleece Jacket | 1                     |
      | Sauce Labs Bolt T-Shirt                                                            | Sauce Labs Bolt T-Shirt                         | 0                     |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                      | Sauce Labs Onesie                               | 2                     |

  @RemoveFromCartTest03
  Scenario Outline: the item(s) should not be displayed in the cart when removed through the 'Your Cart' page
    Given A Standard User is logged in and they have the following items in the cart: <items-to-add>
    And they are on the Swag Labs Cart page
    When they remove the following items from the cart: <items-to-remove>
    Then the following items should no longer be in the cart: <items-to-remove>

    Examples:
      | items-to-add                                                                       | items-to-remove                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                      | Sauce Labs Onesie                               |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt (Red) | Sauce Labs Bike Light, Sauce Labs Fleece Jacket |

  @RemoveFromCartTest04
  Scenario Outline: the item(s) should not be displayed in the cart when removed through the 'Products' page
    Given A Standard User is logged in and they have the following items in the cart: <items-to-add>
    And they are on the Swag Labs Inventory page
    When they remove the following items from the cart: <items-to-remove>
    Then the following items should no longer be in the cart: <items-to-remove>

    Examples:
      | items-to-add                                                                       | items-to-remove                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                      | Sauce Labs Onesie                               |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt (Red) | Sauce Labs Bike Light, Sauce Labs Fleece Jacket |