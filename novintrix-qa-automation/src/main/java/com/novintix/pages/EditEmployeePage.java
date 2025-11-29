package com.novintix.pages;

import com.novintrix.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEmployeePage {

    private WebDriver driver;
    private WaitUtils wait;

    // MENU
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    // SEARCH
    private By searchNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private By searchButton = By.xpath("//button[contains(.,'Search')]");
    private By employeeRow = By.xpath("//div[@role='rowgroup']/div"); // <-- NEW

    // EDIT
    private By editButton = By.xpath("(//i[contains(@class,'bi-pencil')])[1]");

    // FIELDS
    private By firstNameField = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField = By.name("lastName");

    // SAVE
    private By saveButton = By.xpath("//button[contains(.,'Save')]");

    public EditEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 20); // increase timeout
    }

    public void openEmployeeList() {
        wait.clickWhenReady(pimMenu);
        wait.clickWhenReady(employeeListMenu);
    }

    public void searchEmployee(String name) {
        wait.sendKeysWhenVisible(searchNameField, name);
        wait.clickWhenReady(searchButton);

        // NEW – WAIT FOR SEARCH RESULTS
        wait.waitForVisibility(employeeRow);
    }

    public void editEmployee(String searchName, String newFirst, String newMiddle, String newLast) {

        searchEmployee(searchName);

        // NEW — WAIT for edit icon to be clickable
        wait.waitForClickable(editButton);
        wait.clickWhenReady(editButton);

        wait.sendKeysWhenVisible(firstNameField, newFirst);
        wait.sendKeysWhenVisible(middleNameField, newMiddle);
        wait.sendKeysWhenVisible(lastNameField, newLast);

        wait.scrollToElement(saveButton);
        wait.waitForClickable(saveButton);
        wait.clickWhenReady(saveButton);
    }
}
