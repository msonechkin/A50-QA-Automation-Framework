package com.qa.koel;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver pageDriver;

    public BasePage(WebDriver driver){
        this.pageDriver = driver;
    }

}
