package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    static final By CREATE_PLAYLIST_BUTTON = By.xpath("//i[@title='Create a new playlist']");
    static final By NEW_PLAYLIST_BUTTON = By.xpath("//li[text()='New Playlist']");
    static final By CREATE_PLAYLIST_FIELD = By.xpath("//form[@name='create-simple-playlist-form']/input");
    static final By ALL_SONGS = By.xpath("//a[contains(text(), 'All Songs')]");
    static final By PLAYLIST_SONECHKIN = By.xpath("//a[contains(text(), 'sonechkin')]");
    static final By ADD_TO_PLAYLIST_SONECHKIN = By.xpath("//li[contains(text(),sonechkin) and @class='playlist']");
    static final By PLAYLIST_SONECHKIN2 = By.xpath("//a[contains(text(), 'sonechkin2')]");

    static final By LAMENT_SONG_TITLE = By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]");
    static final By CURRENT_PLAYING_SONG_TITLE = By.xpath("//h3");
    static final By DELETE_PLAYLIST_BUTTON = By.xpath("//button[@class='del btn-delete-playlist']");
    static final By DELETE_PLAYLIST_OK_BUTTON = By.xpath("//button[@class='ok']");
    static final By EDIT_PLAYLIST_BUTTON = By.xpath("//li[contains(text(), 'Edit')]");
    static final By RENAME_PLAYLIST_FIELD = By.xpath("//input[@data-testid='inline-playlist-name-input']");


    public WebElement getPlaylistCreateButton() {
        return pageDriver.findElement(CREATE_PLAYLIST_BUTTON);
    }

    public WebElement getNewPlaylistButton() {
        return pageDriver.findElement(NEW_PLAYLIST_BUTTON);
    }

    public WebElement getCreatePlaylistField() {
        return pageDriver.findElement(CREATE_PLAYLIST_FIELD);
    }

    public WebElement getAllSongsButton() {
        return pageDriver.findElement(ALL_SONGS);
    }

    public WebElement getPlaylistSonechkin() {
        return pageDriver.findElement(PLAYLIST_SONECHKIN);
    }
    public WebElement getAddToPlaylistSonechkin() {
        return pageDriver.findElement(ADD_TO_PLAYLIST_SONECHKIN);
    }
    public WebElement getPlaylistSonechkin2() {
        return pageDriver.findElement(PLAYLIST_SONECHKIN2);
    }



    public WebElement getLamentSongTitle() {
        return pageDriver.findElement(LAMENT_SONG_TITLE);
    }

    public WebElement getCurrentPlayingSongTitle() {
        return pageDriver.findElement(CURRENT_PLAYING_SONG_TITLE);
    }

    public WebElement getDeletePlaylistButton() {
        return pageDriver.findElement(DELETE_PLAYLIST_BUTTON);
    }
    public WebElement getDeletePlaylistOKButton() {
        return pageDriver.findElement(DELETE_PLAYLIST_OK_BUTTON);
    }

    public WebElement getEditPlaylistButton() {
        return pageDriver.findElement(EDIT_PLAYLIST_BUTTON);
    }

    public WebElement getRenamePlaylistField() {
        return pageDriver.findElement(RENAME_PLAYLIST_FIELD);
}

}
