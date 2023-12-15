package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AllSongsTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;

    @Test
    public void addSongToPlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'All Songs')]")));
        homePage.getAllSongsButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Lament')]")));
        allSongsPage.getLamentSong().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        allSongsPage.getAddToButton().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'ololo')]")));
        allSongsPage.getAddToOloloPlaylist().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'ololo')]")));
        action.click(homePage.getOloloPlaylist()).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")));
        assertEquals((homePage.getLamentSongTitle()).getText(), "Lament");

    }
    @Test
    public void playSong(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'All Songs')]")));
        homePage.getAllSongsButton().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Lament')]")));

        action.doubleClick(allSongsPage.getLamentSong()).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        Assert.assertEquals(homePage.getCurrentPlayingSongTitle().getText(), "Lament");



    }

}
