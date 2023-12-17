package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver driver) {
        super(driver);
    }

    static final By LAMENT_SONG = By.xpath("//td[contains(text(), 'Lament')]");
    static final By ADD_TO_BUTTON = By.cssSelector(".btn-add-to");




    public WebElement getLamentSong(){
     return pageDriver.findElement(LAMENT_SONG);
    }
    public WebElement getAddToButton(){
        return pageDriver.findElement(ADD_TO_BUTTON);
    }


}
