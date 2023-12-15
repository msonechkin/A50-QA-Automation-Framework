package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    final static By EMAIL_FIELD = By.xpath("//input[@type='email']");
    final static By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    final static By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    final static By REGISTRATION_BUTTON = By.xpath("//a[contains(text(), 'Registration')]");


    public WebElement getLoginButton() {
        return pageDriver.findElement(LOGIN_BUTTON);
    }

    public WebElement getRegistrationButton() {
        return pageDriver.findElement(REGISTRATION_BUTTON);
    }


    public void logIn(String email, String password) {
        WebElement emailField = pageDriver.findElement(EMAIL_FIELD);
        emailField.sendKeys(email);
        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
        WebElement logInButton = pageDriver.findElement(LOGIN_BUTTON);
        logInButton.click();
    }


}
