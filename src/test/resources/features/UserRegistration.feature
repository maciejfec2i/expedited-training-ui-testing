@UserRegistration
Feature: User Registration

  @SmokeTest @UserRegistration1 @RunPostCondition
  Scenario: Registering a valid user
    When A new user registers
    Then the account should be created successfully
#    And they should be able to login