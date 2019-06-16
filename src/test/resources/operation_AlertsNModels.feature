Feature: Alert and Models operation

  Scenario: Bootstrap model
    Given The url is provided
    Then select bootstrap "Bootstrap Modals"
    Then click launch modal of "Multiple Modal Example"
    Then again click on launch modal
    Then cancel model 2
    Then close 1st model

  Scenario: Multiple window modal
    Given The url is provided
    Then select bootstrap "Window Popup Modal"
    Then navigate to new window "Selenium Easy (@seleniumeasy) on Twitter"
    Then validate if navigated to Selenium easy page
    Then navigate back to parent page

  Scenario: Alert box validation
    Given The url is provided
    Then select bootstrap "Javascript Alerts"
    Then click on promt box "Click for Prompt Box"
    Then enter text "test" in javascript promt box

  Scenario: Downloaded file validation
    Given The url is provided
    Then select bootstrap "File Download"
    Then click on enter data and enter data "test"
    Then click on generate file button
    Then click on Download button
    Then verify entered text "test" is present in downloaded text file

