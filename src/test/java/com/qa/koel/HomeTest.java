package com.qa.koel;

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
        homePage.waitUntilVisibilityOfElement(homePage.getAllSongsButton(), 6);
        homePage.getAllSongsButton().click();
        allSongsPage.waitUntilVisibilityOfElement(allSongsPage.getLamentSong(), 6);
        action.doubleClick(allSongsPage.getLamentSong()).perform();
        homePage.waitUntilVisibilityOfElement(homePage.getCurrentPlayingSongTitle(), 6);

        Assert.assertEquals(homePage.getCurrentPlayingSongTitle().getText(), "Lament");


    }

}
