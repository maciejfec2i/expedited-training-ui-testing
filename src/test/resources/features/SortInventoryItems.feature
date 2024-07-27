@SortItemsTests
Feature: When sorting items by a specific filter

  @SortItemsTest01
  Scenario Outline: the items should be sorted correctly
    Given A Standard User is logged in and on the Swag Labs Inventory page
    When they sort items by "<filter>"
    Then the items should be sorted by "<criteria>" in <order> order

    Examples:
      | filter              | criteria | order      |
      | Name (A to Z)       | name     | ascending  |
      | Name (Z to A)       | name     | descending |
      | Price (low to high) | price    | ascending  |
      | Price (high to low) | price    | descending |