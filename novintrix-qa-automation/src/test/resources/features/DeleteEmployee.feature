Feature: Delete Employee

  Scenario: Successfully delete an employee
    Given user is on the login page
    When user logs in with valid credentials
    And user navigates to employee list
    And user deletes employee "Shobi"
    Then employee should be deleted
