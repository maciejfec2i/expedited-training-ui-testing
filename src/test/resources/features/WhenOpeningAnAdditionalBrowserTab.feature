@MultipleWindowsTests
Feature: When opening an additional browser tab

  @MultipleWindowsTest1
  Scenario: the user should be able to switch to the tab and see the page content
    Given the user is on the Windows page
    When they open the "Basic Ajax in new page" link
    Then a new tab should be opened
    And the user should be able to switch to the tab titled "Test Page For Basic Ajax Example"