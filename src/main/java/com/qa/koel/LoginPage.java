package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage  extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(), 'Registration')]")
    WebElement registrationButton;

    public WebElement getEmailField() {
        return emailField;
    }
    public WebElement getPasswordField() {
        return passwordField;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
    public WebElement getRegistrationButton() {
        return registrationButton;
    }


    public void logIn(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }


}
