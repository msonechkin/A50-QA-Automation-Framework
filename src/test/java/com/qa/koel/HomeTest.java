package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void deletePlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        action.click(homePage.getPlaylistCreateButton()).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='New Playlist']")));
        homePage.getNewPlaylistButton().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']/input")));
        homePage.getCreatePlaylistField().sendKeys("qwerty", Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'qwerty')]")));
        homePage.getQwertyPlaylist().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        homePage.getDeletePlaylistButton().click();

        wait.until(ExpectedConditions.invisibilityOf(homePage.getQwertyPlaylist()));
        isPlaylistPresent();

    }

    public boolean isPlaylistPresent() {
        try {
            WebElement playlist = homePage.getQwertyPlaylist();
            return playlist.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;

        }
    }
    @Test
    public void renamePlaylist(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        action.click(homePage.getPlaylistCreateButton()).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='New Playlist']")));
        homePage.getNewPlaylistButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']/input")));
        homePage.getCreatePlaylistField().sendKeys("qwerty", Keys.ENTER);

        WebElement playList = homePage.getOloloPlaylist();
        action.contextClick(playList).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Edit')]")));
        homePage.getEditPlaylistButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        action.moveToElement(homePage.getRenamePlaylistField());

        for (int i = 0; i < playListName.length(); i++) {
            homePage.getRenamePlaylistField().sendKeys(Keys.BACK_SPACE);
        }
        homePage.getRenamePlaylistField().sendKeys("HW21", Keys.ENTER);


    }
}
