Feature: Edit Employee

  Scenario: Successfully edit an existing employee
    Given user is on the login page
    When user logs in with valid credentials
    And user navigates to employee list
    And user edits employee "Shobika" to firstname "Shobi" middlename "J" lastname "Engineer"
    Then employee details should be updated
