package com.qa.koel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayListsTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AllSongsPage allSongsPage;

    public void createPlaylist(String name) {
        homePage = new HomePage(getDriver());
        homePage.waitUntilElementToBeClickable(homePage.getPlaylistCreateButton(), 6);
        action.click(homePage.getPlaylistCreateButton()).perform();
        homePage.waitUntilElementToBeClickable(homePage.getNewPlaylistButton(), 6);
        homePage.getNewPlaylistButton().click();
        homePage.waitUntilElementToBeClickable(homePage.getCreatePlaylistField(), 6);
        homePage.getCreatePlaylistField().sendKeys(name, Keys.ENTER);
    }

    public boolean isPlaylistSonechkinPresent() {
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

        homePage.waitUntilVisibilityOfElement(homePage.getDeletePlaylistButton(), 6);
        homePage.getDeletePlaylistButton().click();
        homePage.waitUntilInvisibilityOfElement(homePage.getPlaylistSonechkin(), 6);

        isPlaylistSonechkinPresent();

    }

    @Test
    public void renamePlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist("sonechkin");

        homePage.waitUntilElementToBeClickable(homePage.getPlaylistSonechkin(),6);
        action.contextClick(homePage.getPlaylistSonechkin()).perform();
        homePage.waitUntilVisibilityOfElement(homePage.getEditPlaylistButton(), 6);
        homePage.getEditPlaylistButton().click();
        homePage.waitUntilElementToBeClickable(homePage.getRenamePlaylistField(), 6);
        action.moveToElement(homePage.getRenamePlaylistField());

        for (int i = 0; i < "sonechkin".length(); i++) {
            homePage.getRenamePlaylistField().sendKeys(Keys.BACK_SPACE);
        }

        homePage.getRenamePlaylistField().sendKeys("sonechkin2", Keys.ENTER);
        homePage.waitUntilVisibilityOfElement(homePage.getPlaylistSonechkin2(), 6);
        homePage.getPlaylistSonechkin().click();
        homePage.waitUntilVisibilityOfElement(homePage.getDeletePlaylistButton(), 6);
        homePage.getDeletePlaylistButton().click();

    }

    @Test
    public void addSongToPlaylist() {

        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist("sonechkin");

        homePage.waitUntilElementToBeClickable(homePage.getAllSongsButton(), 6);
        action.click(homePage.getAllSongsButton()).perform();
        allSongsPage.waitUntilElementToBeClickable(allSongsPage.getLamentSong(), 6);
        allSongsPage.getLamentSong().click();
        allSongsPage.waitUntilVisibilityOfElement(allSongsPage.getAddToButton(), 6);
        allSongsPage.getAddToButton().click();
        homePage.waitUntilVisibilityOfElement(homePage.getAddToPlaylistSonechkin(), 6);
        homePage.getAddToPlaylistSonechkin().click();
        homePage.waitUntilVisibilityOfElement(homePage.getPlaylistSonechkin(), 6);
        action.click(homePage.getPlaylistSonechkin()).perform();
        homePage.waitUntilVisibilityOfElement(homePage.getLamentSongTitle(), 6);

        assertEquals((homePage.getLamentSongTitle()).getText(), "Lament");

        homePage.waitUntilVisibilityOfElement(homePage.getDeletePlaylistButton(), 6);
        homePage.getDeletePlaylistButton().click();
        homePage.waitUntilVisibilityOfElement(homePage.getDeletePlaylistOKButton(), 6);
        homePage.getDeletePlaylistOKButton().click();

    }
}
