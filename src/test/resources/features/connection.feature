Feature: Connect to web Feature
  Verify if user is able to open chrome and navigate to a web page

Scenario: open google.com
    Given user loads browser
    When user navigates to google.com
    Then user sees element hplogo
    Then user takes a screenshot
