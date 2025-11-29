Feature: Add Employee

  Scenario: Successfully add a new employee
    Given user is on the login page
    When user logs in with valid credentials
    And user navigates to add employee page
    And user adds employee with firstname "Shobika" middlename "QA" lastname "Engineer"
    Then employee should be created
