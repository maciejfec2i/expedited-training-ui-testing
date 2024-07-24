Feature: When sorting items by a specific filter

  Scenario Outline: the items should be sorted correctly
    Given A Standard User is logged in and on the Products page
    When they sort items by <filter>
    Then the items should be sorted by <criteria> in <direction> order

    Examples:
      | filter              | criteria | direction  |
      | Name (A to Z)       | name     | ascending  |
      | Name (Z to A)       | name     | descending |
      | Price (low to high) | price    | ascending  |
      | Price (high to low) | price    | descending |