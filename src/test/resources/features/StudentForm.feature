Feature: Automation Practice Form

  Scenario Outline: Verify that the user can successfully submit the form with valid data
    Given The user is on the student form page
    When The user fills in the student form with valid data
      | firstName   | lastName   | email   | gender   | mobile     | dateOfBirth   | subjects       | hobbies     | picture    | currentAddress   | state   | city    |
      | <firstName> | <lastName> | <email> | <gender> | <mobile>   | <dateOfBirth> | <subjects>     | <hobbies>   | <picture>  | <currentAddress> | <state> | <city>  |
    And The user clicks the submit button
    Then The form should be successfully submitted
    And The user should see a success message

    Examples:
      | firstName | lastName | email                 | gender | mobile     | dateOfBirth | subjects               | hobbies          | picture            | currentAddress | state | city  |
      | John      | Doe      | john.doe@example.com  | Male   | 1234567890 | 10 Sep 1990 | Maths, Computer Science| Sports, Reading  | path/to/picture.jpg| 123 Main St    | NCR   | Delhi |
      | Jane      | Smith    | jane.smith@example.com| Female | 0987654321 | 22 Dec 1988 | English, Chemistry     | Music, Sports   | path/to/another.jpg| 456 Maple Ave  | NCR   | Gurgaon |

  Scenario: Verify that all mandatory fields are required
    Given The user is on the student form page
    When The user clicks the submit button without filling in any data
    Then The user should see mandatory field validation messages with "First Name", "Last Name", "Gender" and "Mobile" fields

  Scenario Outline: Verify that the user cannot submit the form with invalid email
    Given The user is on the student form page
    When The user fills in the form with an invalid email
      | firstName   | lastName   | email   | gender   | mobile     |
      | <firstName> | <lastName> | <email> | <gender> | <mobile>   |
    And The user clicks the submit button.
    Then The user should see an invalid email validation message
    Examples:
      | firstName | lastName | email         | gender | mobile     |
      | John      | Doe      | john.doe@com  | Male   | 1234567890 |
      | Jane      | Smith    | jane.smith    | Female | 0987654321 |


  Scenario Outline: Verify that the user cannot submit the form with invalid mobile number
    Given The user is on the student form page
    When The user fills in the form with invalid mobile number
      | firstName   | lastName   | email   | gender   | mobile     |
      | <firstName> | <lastName> | <email> | <gender> | <mobile>   |
    And The user clicks the submit button
    Then The user should see an invalid mobile number validation message
    Examples:
      | firstName | lastName | email                 | gender | mobile     |
      | John      | Doe      | john.doe@example.com  | Male   | 123        |
      | Jane      | Smith    | jane.smith@abc.com    | Female | ABDCEFDSAD |

  Scenario Outline: Verify that the user can upload a picture
    Given The user is on the student form page
    When The user fills in the student form with valid data
      | firstName   | lastName   | email   | gender   | mobile     | dateOfBirth   | subjects       | hobbies     | picture    | currentAddress   | state   | city    |
      | <firstName> | <lastName> | <email> | <gender> | <mobile>   | <dateOfBirth> | <subjects>     | <hobbies>   | <picture>  | <currentAddress> | <state> | <city>  |
   And The user uploads the picture
    And The user clicks the submit button
    Then The picture should be uploaded successfully
    Examples:
      | firstName | lastName | email                 | gender | mobile     | dateOfBirth | subjects               | hobbies          | picture            | currentAddress | state | city  |
      | John      | Doe      | john.doe@example.com  | Male   | 1234567890 | 10 Sep 1990 | Maths, Computer Science| Sports, Reading  | path/to/picture.jpg| 123 Main St    | NCR   | Delhi |

