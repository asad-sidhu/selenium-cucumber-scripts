Feature: Web Tables

  Scenario: Verify All fields are mandatory on Add Record form.
    Given The user is on the webtables page
    When The user clicks the Add button
    And The user clicks submit
    Then The user should see the Mandatory Field alerts in all the fields

  Scenario Outline: Verify user is able to add records in the user table.
    Given The user is on the webtables page
    When The user clicks the Add button
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

  Scenario Outline: Verify user is able to Edit records in the user table.
    Given The user is on the webtables page
    When The user clicks the Edit button
    And The user fills in the account details
      | firstname   | lastname   | email   | age   | salary   | department  |
      | <firstname> | <lastname> | <email> | <age> | <salary> | <department>  |
    And The user clicks submit
    Then The user should see the updated information in the table
      | firstname   | lastname   | email   | age   | salary   | department  |
      | <firstname> | <lastname> | <email> | <age> | <salary> | <department>  |

    Examples:
      | firstname | lastname | email                | age    | salary      | department     |
      | Asad      | Sidhu      | asad.sidhu@example.com | 21     | 200000      | Software      |

  Scenario: Verify User is able to delete a record.
    Given The user is on the webtables page
    When User takes count of the records
    And The user clicks the Delete button
    Then The Record should be Deleted

  Scenario Outline: Verify user is able to search records in the user table.
    Given The user is on the webtables page
    When The user types in the searchbox
      | searchQuery   |
      | <searchQuery>   |
    Then The user should see the search results in the table
      | searchQuery   |
      | <searchQuery>   |

    Examples:
      | searchQuery   |
      | Cierra   |
      | Vega |
      | 39   |
      | cierra@example.com |
      | 10000   |
      | Insurance |
