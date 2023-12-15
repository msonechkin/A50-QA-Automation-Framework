package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    static final By CREATE_PLAYLIST_BUTTON = By.xpath("//i[@title='Create a new playlist']");
    static final By NEW_PLAYLIST_BUTTON = By.xpath("//li[text()='New Playlist']");
    static final By CREATE_PLAYLIST_FIELD = By.xpath("//form[@name='create-simple-playlist-form']/input");
    static final By ALL_SONGS = By.xpath("//a[contains(text(), 'All Songs')]");
    static final By OLOLO_PLAYLIST = By.xpath("//a[contains(text(), 'ololo')]");
    static final By QWERTY_PLAYLIST = By.xpath("//a[contains(text(), 'qwerty')]");
    static final By LAMENT_SONG_TITLE = By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]");
    static final By CURRENT_PLAYING_SONG_TITLE = By.xpath("//h3");
    static final By DELETE_PLAYLIST_BUTTON = By.xpath("//button[@class='del btn-delete-playlist']");
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

    public WebElement getOloloPlaylist() {
        return pageDriver.findElement(OLOLO_PLAYLIST);
    }

    public WebElement getQwertyPlaylist() {
        return pageDriver.findElement(QWERTY_PLAYLIST);
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

    public WebElement getEditPlaylistButton() {
        return pageDriver.findElement(EDIT_PLAYLIST_BUTTON);
    }

    public WebElement getRenamePlaylistField() {
        return pageDriver.findElement(RENAME_PLAYLIST_FIELD);
}

}
