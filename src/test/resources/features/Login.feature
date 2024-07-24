@LoginTests
Feature: When logging into the Swag Labs site

  @LoginTest01
  Scenario: a Standard User should be redirected to the Products page
    Given A Standard User is on the Swag Labs Login page
    When they attempt to log into the site
    Then they should be successfully redirected to the Products page

  @LoginTest02
  Scenario: a Locked Out User should see the locked out error message
    Given A Locked Out User is on the Swag Labs Login page
    When they attempt to log into the site
    Then they should see the locked out error message

  @LoginTest03 @LoginTest04
  Scenario Outline: a user with invalid credentials should see the invalid credentials error message
    Given A <user> is on the Swag Labs Login page
    When they attempt to log into the site
    Then they should see the invalid credentials error message

    Examples:
      | user                  |
      | Invalid Username User |
      | Invalid Password User |
