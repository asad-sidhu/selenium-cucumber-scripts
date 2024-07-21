Feature: Buttons Page

  Scenario: Verify Click Button functionality
    Given The user is on the buttons page
    When The user clicks the Click button
    Then The output message for "Single Click" should be "You have done a dynamic click"

  Scenario: Verify Right Click Button functionality
    Given The user is on the buttons page
    When The user right-clicks the Right Click button
    Then The output message for "Right Click" should be "You have done a right click"

  Scenario: Verify Double Click Button functionality
    Given The user is on the buttons page
    When The user double-clicks the Double Click button
    Then The output message for "Double Click" should be "You have done a double click"
