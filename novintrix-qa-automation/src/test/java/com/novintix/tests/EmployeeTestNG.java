package com.novintix.tests;

import com.assignment.driver.DriverFactory;
import com.novintix.pages.AddEmployeePage;
import com.novintix.pages.EditEmployeePage;
import com.novintix.pages.DeleteEmployeePage;
import com.novintix.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class EmployeeTestNG {

    private WebDriver driver;
    private LoginPage login;
    private AddEmployeePage addPage;
    private EditEmployeePage editPage;
    private DeleteEmployeePage deletePage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();

        login = new LoginPage(driver);
        addPage = new AddEmployeePage(driver);
        editPage = new EditEmployeePage(driver);
        deletePage = new DeleteEmployeePage(driver);

        login.openUrl();  
        login.login("Admin", "admin123");  
    }

    @Test(priority = 1)
    public void testAddEmployee() {
        addPage.openAddEmployee();
        addPage.addEmployee("Shobika", "QA", "Engineer");
    }

    @Test(priority = 2)
    
    
    public void testEditEmployee() {
        editPage.openEmployeeList();
        editPage.editEmployee("Shobika", "Shobi", "J", "Engineer");  // no try-catch needed
    }


    @Test(priority = 3)
    public void testDeleteEmployee() {
        deletePage.openEmployeeList();
        deletePage.deleteEmployee("Shobi");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
