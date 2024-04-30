@JSAlertsTests
Feature: When dealing with JS Alerts And Prompts

  @JSAlertsTest1
  Scenario Outline: the correct response should be displayed based on how the alert was handled
    Given the user is on the "JavaScript Alerts" page
    And they have triggered a "<prompt-type>"
    When they perform a <prompt-action>
    Then the page should display that "<expected-result>"

    Examples:
      | prompt-type | prompt-action              | expected-result                   |
      | JS Alert    | Click:OK                   | You successfully clicked an alert |
      | JS Confirm  | Click:OK                   | You clicked: Ok                   |
      | JS Confirm  | Click:Cancel               | You clicked: Cancel               |
      | JS Prompt   | Type:Hello there!;Click:OK | You entered: Hello there!         |