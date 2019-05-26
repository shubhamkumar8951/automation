Feature: test Table

  Scenario: Logging and selecting last value of table
    Given The url is provided
    Then select table "Table Pagination"
    Then navigate to last page

  Scenario: Logging and checking data filter
    Given The url is provided
    Then select table "Table Data Search"
    Then click on filter field
    Then enter to be filter value "SE"
    Then verify if search result is filtered by text "SE" or "se" for column header "Task"

  Scenario: Logging and checking data sort
    Given The url is provided
    Then select table "Table Sort & Search"
    Then select decending order icon in "Name"
