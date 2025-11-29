package com.novintix.pages;

import com.novintrix.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteEmployeePage {

    private WebDriver driver;
    private WaitUtils wait;

    // LOCATORS
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    private By searchNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private By searchButton = By.xpath("//button[contains(.,'Search')]");

    private By deleteButton = By.xpath("(//i[contains(@class,'bi-trash')])[1]");
    private By confirmDeleteButton = By.xpath("//button[contains(.,'Yes, Delete')]");

    private By table = By.xpath("//div[@role='table']");

    public DeleteEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    // OPEN EMPLOYEE LIST PAGE
    public void openEmployeeList() {
        wait.clickWhenReady(pimMenu);
        wait.clickWhenReady(employeeListMenu);
    }

    // SEARCH EMPLOYEE
    public void searchEmployee(String name) {
        wait.sendKeysWhenVisible(searchNameField, name);
        wait.clickWhenReady(searchButton);
        wait.waitForVisibility(table); // Wait for results to load
    }

    // DELETE EMPLOYEE
    public void deleteEmployee(String employeeName) {
        searchEmployee(employeeName);
        wait.clickWhenReady(deleteButton);
        wait.clickWhenReady(confirmDeleteButton);
    }
}

