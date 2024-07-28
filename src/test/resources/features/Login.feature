@LoginTests
Feature: When logging into the Swag Labs site

  @SmokeTest @LoginTest01
  Scenario: a Standard User should be redirected to the Products page
    Given A Standard User was able to open the Swag Labs Login page
    When they attempt to log in to the site
    Then they should be successfully redirected to the Swag Labs Inventory page

  @LoginTest02
  Scenario: a Locked Out User should see the locked out error message
    Given A Locked Out User was able to open the Swag Labs Login page
    When they attempt to log in to the site
    Then they should see the locked out error message

  @LoginTest03 @LoginTest04
  Scenario Outline: a user with invalid credentials should see the invalid credentials error message
    Given A <user> was able to open the Swag Labs Login page
    When they attempt to log in to the site
    Then they should see the invalid credentials error message

    Examples:
      | user                       |
      | User With Invalid Username |
      | User With Invalid Password |
