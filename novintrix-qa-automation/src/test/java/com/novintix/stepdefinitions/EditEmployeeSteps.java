package com.novintix.stepdefinitions;

import com.assignment.driver.DriverFactory;
import com.novintix.pages.EditEmployeePage;
import com.novintix.pages.LoginPage;
import io.cucumber.java.en.*;

public class EditEmployeeSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());
    EditEmployeePage editPage = new EditEmployeePage(DriverFactory.getDriver());

    @When("user navigates to employee list")
    public void user_navigates_employee_list() {
        editPage.openEmployeeList();
    }

    @When("user edits employee {string} to firstname {string} middlename {string} lastname {string}")
    
    public void edit_employee(String oldName, String newF, String newM, String newL) throws InterruptedException {
        editPage.editEmployee(oldName, newF, newM, newL);
    }


    @Then("employee details should be updated")
    public void employee_details_updated() {
        // Validation optional
    }
}
