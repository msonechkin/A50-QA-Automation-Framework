package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static By EMAIL_FIELD = By.xpath("//input[@type='email']");
    public static By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    public static By LOGIN_BUTTON = By.xpath("//button[@type='submit']");


    public void logIn(String email, String password) {
        WebElement emailField = pageDriver.findElement(EMAIL_FIELD);
        emailField.sendKeys(email);
        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
        WebElement logInButton = pageDriver.findElement(LOGIN_BUTTON);
        logInButton.click();
    }
}
