package com.qa.koel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//i[@title='Create a new playlist']")
    WebElement createPlaylistButton;
    @FindBy(xpath = "//li[text()='New Playlist']")
    WebElement newPlaylistButton;
    @FindBy(xpath = "//form[@name='create-simple-playlist-form']/input")
    WebElement createPlaylistField;
    @FindBy(xpath = "//a[contains(text(), 'All Songs')]")
    WebElement allSongs;
    @FindBy(xpath = "//a[contains(text(), 'sonechkin')]")
    WebElement playlistSonechkin;
    @FindBy(xpath = "//li[contains(text(),sonechkin) and @class='playlist']")
    WebElement addToPlaylistSonechkin;
    @FindBy(xpath = "//a[contains(text(), 'sonechkin2')]")
    WebElement playlistSonechkin2;
    @FindBy(xpath = "//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")
    WebElement lamentSongTitle;
    @FindBy(xpath = "//h3")
    WebElement currentPlayingSongTitle;
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    WebElement deletePlaylistButton;
    @FindBy(xpath = "//button[@class='ok']")
    WebElement deletePlaylistOkButton;
    @FindBy(xpath = "//li[contains(text(), 'Edit')]")
    WebElement editPlaylistButton;
    @FindBy(xpath = "//input[@data-testid='inline-playlist-name-input']")
    WebElement renamePlaylistField;

    public WebElement getPlaylistCreateButton() {
        return createPlaylistButton;
    }

    public WebElement getNewPlaylistButton() {
        return newPlaylistButton;
    }

    public WebElement getCreatePlaylistField() {
        return createPlaylistField;
    }

    public WebElement getAllSongsButton() {
        return allSongs;
    }

    public WebElement getPlaylistSonechkin() {
        return playlistSonechkin;
    }

    public WebElement getAddToPlaylistSonechkin() {
        return addToPlaylistSonechkin;
    }

    public WebElement getPlaylistSonechkin2() {
        return playlistSonechkin2;
    }

    public WebElement getLamentSongTitle() {
        return lamentSongTitle;
    }

    public WebElement getCurrentPlayingSongTitle() {
        return currentPlayingSongTitle;
    }

    public WebElement getDeletePlaylistButton() {
        return deletePlaylistButton;
    }

    public WebElement getDeletePlaylistOKButton() {
        return deletePlaylistOkButton;
    }

    public WebElement getEditPlaylistButton() {
        return editPlaylistButton;
    }

    public WebElement getRenamePlaylistField() {
        return renamePlaylistField;
    }

}
