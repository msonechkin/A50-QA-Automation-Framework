package com.qa.koel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver;
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.pageDriver = driver;
    }

    void waitUntilInvisibilityOfElement(WebElement element, int timeout){
        wait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    void waitUntilVisibilityOfElement(WebElement element, int timeout){
        wait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    void waitUntilElementToBeClickable(WebElement element, int timeout){
        wait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
