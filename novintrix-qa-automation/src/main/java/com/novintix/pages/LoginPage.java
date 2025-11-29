package com.novintix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.novintrix.utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 10);
    }

    // ✅ FIX: Use full direct login URL
    public void openUrl() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        		
    }

    

    public void login(String user, String pass) {
        wait.sendKeysWhenVisible(username, user);
        wait.sendKeysWhenVisible(password, pass);
        wait.clickWhenReady(loginBtn);
    }
}
