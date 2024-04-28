Feature: When sorting a table

  Scenario Outline: the rows should be sorted correctly based on sorting order and specified column
    Given The user is on the "Tables" page
    When they sort the table by "<column>" in "<order>" order
    Then the rows should be sorted correctly by "<column>" in "<order>" order

    Examples:
      | column     | order      |
      | Last Name  | ascending  |
      | Last Name  | descending |
      | First Name | ascending  |
      | First Name | descending |
      | Due        | ascending  |
      | Due        | descending |