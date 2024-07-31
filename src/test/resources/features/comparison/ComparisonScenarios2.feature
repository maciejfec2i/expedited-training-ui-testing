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