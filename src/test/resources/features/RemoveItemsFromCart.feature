Feature: When removing item(s) from the cart

  Scenario Outline: the 'Add to cart' button on the item product card on the 'Products' page should be displayed
    Given A Standard User has the following item in the cart: <item>
    When they remove the following item from the cart: <item>
    Then the Add to cart button should be displayed for the following item: <item>

    Examples:
      | item                     |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |

  Scenario Outline: the cart badge should display the correct number of items
    Given A Standard User has the following items in the cart: <items-to-add>
    When they remove the following items from the cart: <items-to-remove>
    Then the cart badge should display that the cart contains <expected-num-of-items> items

    Examples:
      | items-to-add                                                                 | items-to-remove                                 | expected-num-of-items |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt | Sauce Labs Bike Light, Sauce Labs Fleece Jacket | 1                     |
      | Sauce Labs Bolt T-Shirt                                                      | Sauce Labs Bolt T-Shirt                         | 0                     |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                | Sauce Labs Onesie                               | 2                     |

  Scenario Outline: the item(s) should not be displayed in the cart when removed through the 'Your Cart' page
    Given A Standard User has the following items in the cart: <items-to-add>
    And they are on the Your Cart page
    When they remove the following items from the cart: <items-to-remove>
    Then the following items should no longer be in the cart: <items-to-remove>

    Examples:
      | items-to-add                                                                 | items-to-remove                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                | Sauce Labs Onesie                               |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt | Sauce Labs Bike Light, Sauce Labs Fleece Jacket |

  Scenario Outline: the item(s) should not be displayed in the cart when removed through the 'Products' page
    Given A Standard User has the following items in the cart: <items-to-add>
    And they are on the Products page
    When they remove the following items from the cart: <items-to-remove>
    Then the following items should no longer be in the cart: <items-to-remove>

    Examples:
      | items-to-add                                                                 | items-to-remove                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light                | Sauce Labs Onesie                               |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt | Sauce Labs Bike Light, Sauce Labs Fleece Jacket |