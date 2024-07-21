Feature: Radio Button Selection

  Scenario: Verify radio buttons are displayed correctly
    Given The user is on the radio button page
    Then The user should see the radio buttons "Yes", "Impressive", and "No"

  Scenario: Verify radio buttons are displayed correctly
    Given The user is on the radio button page
    Then The "No" radio button should be disabled

  Scenario: Verify selecting "Yes" radio button shows correct output
    Given The user is on the radio button page
    When The user selects the "Yes" radio button
    Then The output should state "You have selected Yes"

  Scenario: Verify selecting "Impressive" radio button shows correct output
    Given The user is on the radio button page
    When The user selects the "Impressive" radio button
    Then The output should state "You have selected Impressive"
