package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist(playListName);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'All Songs')]")));
        getDriver().findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Lament')]")));
        getDriver().findElement(By.xpath("//td[contains(text(), 'Lament')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        getDriver().findElement(By.cssSelector(".btn-add-to")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), '" + playListName + "')]")));
        getDriver().findElement(By.xpath("//li[contains(text(), '" + playListName + "')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playListName + "')]")));
        WebElement button = getDriver().findElement(By.xpath("//a[contains(text(), '" + playListName + "')]"));

        Actions action = new Actions(getDriver());
        action.click(button).perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")));
        assertEquals(getDriver().findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")).getText(), "Lament");

    }

}
