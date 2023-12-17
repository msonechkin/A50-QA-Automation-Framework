package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AllSongsPage allSongsPage;
    @Test
    public void playSong() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'All Songs')]")));
        homePage.getAllSongsButton().click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Lament')]")));

        action.doubleClick(allSongsPage.getLamentSong()).perform();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        Assert.assertEquals(homePage.getCurrentPlayingSongTitle().getText(), "Lament");


    }

}
