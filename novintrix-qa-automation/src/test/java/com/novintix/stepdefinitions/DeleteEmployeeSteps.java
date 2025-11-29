package com.novintix.stepdefinitions;

import com.assignment.driver.DriverFactory;
import com.novintix.pages.DeleteEmployeePage;
import com.novintix.pages.LoginPage;
import io.cucumber.java.en.*;

public class DeleteEmployeeSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());
    DeleteEmployeePage deletePage = new DeleteEmployeePage(DriverFactory.getDriver());

    @When("user deletes employee {string}")
    public void user_deletes_employee(String name) {
        deletePage.deleteEmployee(name);
    }

    @Then("employee should be deleted")
    public void employee_should_be_deleted() {
        // Optional
    }
}

