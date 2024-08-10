Feature: Comparison Scenarios 2

  @Scenario1
  Scenario: When logging into the Swag Labs site a Standard User should be redirected to the Products page
    Given A Standard User was able to open the Swag Labs Login page
    When they attempt to log in to the site
    Then they should be successfully redirected to the Swag Labs Inventory page

  @Scenario2
  Scenario: When logging into the Swag Labs site a Locked Out User should see the locked out error message
    Given A Locked Out User was able to open the Swag Labs Login page
    When they attempt to log in to the site
    Then they should see the locked out error message

  @Scenario3
  Scenario Outline: the 'Remove' button on the item product card on the 'Products' page should be displayed
    Given A Standard User is logged in and on the Swag Labs Inventory page
    When they add the following items to the cart: <item>
    Then the Remove button should be displayed for the following items: <item>

    Examples:
      | item                     |
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Onesie        |

