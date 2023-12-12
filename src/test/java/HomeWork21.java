import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.UUID;

public class HomeWork21 extends BaseTest {

    String playListName = UUID.randomUUID().toString();

    @Test
    public void renamePlaylist() throws InterruptedException {
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist(playListName);
        WebElement playList = getDriver().findElement(By.xpath("//a[contains(text(), '" + playListName + "')]"));
        action.contextClick(playList).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Edit')]")));
        getDriver().findElement(By.xpath("//li[contains(text(), 'Edit')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement playListField = getDriver().findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        action.moveToElement(playListField);

        for (int i = 0; i < playListName.length(); i++) {
            playListField.sendKeys(Keys.BACK_SPACE);
        }
        playListField.sendKeys("qwerty", Keys.ENTER);


    }
}
