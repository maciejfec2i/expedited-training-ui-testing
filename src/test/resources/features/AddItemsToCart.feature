Feature: When adding item(s) to the cart

  Scenario Outline: the 'Remove' button on the item product card on the 'Products' page should be displayed
    Given A Standard User is logged in and on the Products page
    When they add the following item to the cart: <item>
    Then the Remove button should be displayed for the following item: <item>

    Examples:
      | item                     |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |

  Scenario Outline: the cart badge should display the correct number of items
    Given A Standard User is logged in and on the Products page
    When they add the following items to the cart: <items>
    Then the cart badge should display that the cart contains <expected-num-of-items> items

    Examples:
      | items                                                                                   | expected-num-of-items |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            | 3                     |
      | Sauce Labs Bolt T-Shirt                                                                 | 1                     |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket | 4                     |

  Scenario Outline: the items should be displayed in the cart
    Given A Standard User is logged in and on the Products page
    When they add the following items to the cart: <items>
    Then the items should be displayed on the Your Cart page

    Examples:
      | items                                                                                   |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            |
      | Sauce Labs Bolt T-Shirt                                                                 |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket |

  Scenario Outline: the number of items displayed on the cart badge should be the same as the number of items in the cart
    Given A Standard User has the following items in the cart: <items>
    Then the cart should contain <expected-num-of-items> items
    And the cart badge should display that the cart contains <expected-num-of-items> items

    Examples:
      | items                                                                                   | expected-num-of-items |
      | Sauce Labs Bike Light, Sauce Labs Fleece Jacket, Test.allTheThings() T-Shirt            | 3                     |
      | Sauce Labs Bolt T-Shirt                                                                 | 1                     |
      | Sauce Labs Backpack, Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Fleece Jacket | 4                     |