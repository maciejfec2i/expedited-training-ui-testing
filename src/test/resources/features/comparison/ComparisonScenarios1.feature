Feature: Comparison Scenarios 1

  @Scenario1
  Scenario: When logging into the Swag Labs site a Standard User should be redirected to the Products page
    Given I open the "https://www.saucedemo.com/" url
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click "Login"
    Then I should be on the "https://www.saucedemo.com/inventory.html" url
    And I should see page title as "Products"

  @Scenario2
  Scenario: When logging into the Swag Labs site a Locked Out User should see the locked out error message
    Given I open the "https://www.saucedemo.com/" url
    When I enter the username "standard_user"
    And I enter the password "secret_sauce"
    And I click "Login"
    Then I should see error message
    And error message should have text "Sorry, this user has been locked out"

    @Scenario3
    Scenario Outline: the 'Remove' button on the item product card on the 'Products' page should be displayed
      Given I open the "https://www.saucedemo.com/" url
      And I enter the username "standard_user"
      And I enter the password "secret_sauce"
      And I click "Login"
      And I am on the "Products" page
      When I click on "Add to cart" button for "<item>"
      Then the "Remove" button should be visible for "<item>"

      Examples:
        | item                     |
        | Sauce Labs Backpack      |
        | Sauce Labs Fleece Jacket |
        | Sauce Labs Onesie        |
