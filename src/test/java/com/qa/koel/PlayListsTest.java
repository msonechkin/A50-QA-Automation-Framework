package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class PlayListsTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AllSongsPage allSongsPage;

    public void createPlaylist(String name){
        homePage = new HomePage(getDriver());
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']")));
        action.click(homePage.getPlaylistCreateButton()).perform();
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='New Playlist']")));
        homePage.getNewPlaylistButton().click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']/input")));
        homePage.getCreatePlaylistField().sendKeys(name, Keys.ENTER);
    }
    public boolean isPlaylistPresent() {
        try {
            WebElement playlist = homePage.getPlaylistSonechkin();
            return playlist.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void deletePlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        createPlaylist("sonechkin");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        homePage.getDeletePlaylistButton().click();

        explicitWait.until(ExpectedConditions.invisibilityOf(homePage.getPlaylistSonechkin()));
        isPlaylistPresent();

    }
    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        createPlaylist("sonechkin");

        WebElement playList = homePage.getPlaylistSonechkin();
        action.contextClick(playList).perform();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Edit')]")));
        homePage.getEditPlaylistButton().click();

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        action.moveToElement(homePage.getRenamePlaylistField());

        for (int i = 0; i < "sonechkin".length(); i++) {
            homePage.getRenamePlaylistField().sendKeys(Keys.BACK_SPACE);
        }
        homePage.getRenamePlaylistField().sendKeys("sonechkin2", Keys.ENTER);

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'sonechkin2')]")));
        homePage.getPlaylistSonechkin().click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        homePage.getDeletePlaylistButton().click();

        explicitWait.until(ExpectedConditions.invisibilityOf(homePage.getPlaylistSonechkin()));
        isPlaylistPresent();


    }
    @Test
    public void addSongToPlaylist() {

        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist("sonechkin");

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'All Songs')]")));
        action.click(homePage.getAllSongsButton()).perform();

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Lament')]")));
        allSongsPage.getLamentSong().click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        allSongsPage.getAddToButton().click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'sonechkin')]")));
        homePage.getADdToPlaylistSonechkin().click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'sonechkin')]")));
        action.click(homePage.getPlaylistSonechkin()).perform();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")));
        assertEquals((homePage.getLamentSongTitle()).getText(), "Lament");

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        homePage.getDeletePlaylistButton().click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
        homePage.getDeletePlaylistOKButton().click();

    }
}
