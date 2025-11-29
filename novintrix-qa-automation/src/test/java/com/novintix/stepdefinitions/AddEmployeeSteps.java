package com.novintix.stepdefinitions;

import com.assignment.driver.DriverFactory;
import com.novintix.pages.AddEmployeePage;
import com.novintix.pages.LoginPage;
import io.cucumber.java.en.*;

public class AddEmployeeSteps {

    LoginPage login = new LoginPage(DriverFactory.getDriver());
    AddEmployeePage addPage = new AddEmployeePage(DriverFactory.getDriver());

    @Given("user is on the login page")
    public void user_is_on_login_page() {
        login.openUrl();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_valid_credentials() {
        login.login("Admin", "admin123");
    }

    @When("user navigates to add employee page")
    public void user_navigates_to_add_employee_page() {
        addPage.openAddEmployee();
    }

    @When("user adds employee with firstname {string} middlename {string} lastname {string}")
    public void user_adds_employee(String f, String m, String l) {
        addPage.addEmployee(f, m, l);
    }

    @Then("employee should be created")
    public void employee_should_be_created() {
        // Validation optional
    }
}
