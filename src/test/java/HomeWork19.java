import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        createPlaylist(playListName);
        //playListName = UUID.randomUUID().toString();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playListName + "')]")));
        WebElement playList = getDriver().findElement(By.xpath("//a[contains(text(), '" + playListName + "')]"));
        playList.click();
        //click on a playlist


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        getDriver().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();
        //delete a playlist

        wait.until(ExpectedConditions.invisibilityOf(playList));


        isVisible(playList);


    }

    public boolean isVisible(WebElement element) {
        try {
            element.isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
        return true;
    }
}
