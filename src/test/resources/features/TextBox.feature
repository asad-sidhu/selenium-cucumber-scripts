Feature: Text Box Form

  Scenario: Verify user is able to submit the form with valid data
    Given The user is on the text box page
    When The user fills in the form with valid data
      | fullName         | email              | currentAddress         | permanentAddress    |
      | John Doe         | john.doe@example.com | 123 Current Address    | 456 Permanent Address |
    And The user clicks the submit button
    Then The user should see the submitted data in the output section
      | fullName         | email              | currentAddress         | permanentAddress    |
      | John Doe         | john.doe@example.com | 123 Current Address    | 456 Permanent Address |

  Scenario Outline: Verify user is not able to submit the form with invalid email
    Given The user is on the text box page
    When The user fills in the form with invalid email
      | fullName         | email       | currentAddress         | permanentAddress    |
      | <fullName>       | <email>     | <currentAddress>       | <permanentAddress>  |
    And The user clicks the submit button
    Then The user should see an invalid email alert

    Examples:
      | fullName | email                | currentAddress         | permanentAddress    |
      | John Doe | john.doe@com         | 123 Current Address    | 456 Permanent Address |
      | Jane Doe | jane.doe@.example.com | 789 Current Address    | 012 Permanent Address |

  Scenario: Verify user can leave permanent address empty
    Given The user is on the text box page
    When The user fills in the form without permanent address
      | fullName         | email              | currentAddress         | permanentAddress |
      | John Doe         | john.doe@example.com | 123 Current Address    |                  |
    And The user clicks the submit button
    Then The user should see the submitted data in the output section
      | fullName         | email              | currentAddress         | permanentAddress |
      | John Doe         | john.doe@example.com | 123 Current Address    |                  |
