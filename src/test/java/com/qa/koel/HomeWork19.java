package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist(playListName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playListName + "')]")));
        WebElement playList = getDriver().findElement(By.xpath("//a[contains(text(), '" + playListName + "')]"));
        playList.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        getDriver().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();

        wait.until(ExpectedConditions.invisibilityOf(playList));
        Assert.assertEquals(getDriver().findElements(By.xpath("//a[contains(text(), '" + playListName + "')]")).size(), 0);

    }

}
