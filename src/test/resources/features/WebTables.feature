Feature: Web Tables

  Scenario Outline: User wants to Add entries into web table
    Given The user is on the webtables page
    When The user clicks the "Add" button
    And The user fills in the account details
      | firstname   | lastname   | email   | age   | salary   | department  |
      | <firstname> | <lastname> | <email> | <age> | <salary> | <department>  |
    And The user clicks submit
    Then The user should see the information in the table
      | firstname   | lastname   | email   | age   | salary   | department  |
      | <firstname> | <lastname> | <email> | <age> | <salary> | <department>  |

    Examples:
      | firstname | lastname | email                | age    | salary      | department     |
      | John      | Doe      | john.doe@example.com | 21     | 200000      | Software      |
#      | Jane      | Smith    | jane.smith@example.com | 22      | 300000       | Admin      |
#      | Alice     | Johnson  | alice.johnson@example.com | 23     | 400000      | HR      |

  Scenario: Verify All fields are mandatory on Add Record form
    Given The user is on the webtables page
    When The user clicks the "Add" button
    And The user clicks submit
    Then The user should see the Mandatory Field alerts in all the fields
