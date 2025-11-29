package com.novintix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.novintrix.utils.WaitUtils;

public class AddEmployeePage {
    private WebDriver driver;
    private WaitUtils wait;

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addEmployee = By.xpath("//a[text()='Add Employee']");
    private By firstName = By.name("firstName");
    private By middleName = By.name("middleName");
    private By lastName = By.name("lastName");
    private By saveBtn = By.xpath("//button[contains(.,'Save')]");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    public void openAddEmployee() {
        wait.clickWhenReady(pimMenu);
        wait.clickWhenReady(addEmployee);
    }

    public void addEmployee(String f, String m, String l) {
        wait.sendKeysWhenVisible(firstName, f);
        wait.sendKeysWhenVisible(middleName, m);
        wait.sendKeysWhenVisible(lastName, l);
        wait.clickWhenReady(saveBtn);
    }
}
