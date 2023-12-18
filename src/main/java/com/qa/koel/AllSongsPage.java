package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[contains(text(), 'Lament')]")
    WebElement lamentSong;
    @FindBy(css = ".btn-add-to")
    WebElement addToButton;

    public WebElement getLamentSong(){
     return lamentSong;
    }
    public WebElement getAddToButton(){
        return addToButton;
    }


}
