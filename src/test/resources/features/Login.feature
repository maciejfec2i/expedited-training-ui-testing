Feature: When logging into the Swag Labs site

  Scenario: a Standard User should be redirected to the Products page
    Given A Standard User is on the Login page
    When they attempt to log in to the site
    Then they should be successfully redirected to the Products page

  Scenario: a Locked Out User should see the locked out error message
    Given A Locked Out User is on the Login page
    When they attempt to log in to the site
    Then they should see the locked out error message

  Scenario Outline: a user with invalid credentials should see the error message for invalid credentials
    Given A <user> is on the Login page
    When they attempt to log in to the site
    Then they should see the invalid credentials error message

    Examples:
      | user                  |
      | Invalid Username User |
      | Invalid Password User |
