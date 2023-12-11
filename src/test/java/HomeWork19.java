import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test
    public void deletePlaylist() {
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        Actions action = new Actions(getDriver());

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        WebElement create = getDriver().findElement(By.xpath("//i[@title='Create a new playlist']"));
        action.click(create).perform();

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='New Playlist']")));
        getDriver().findElement(By.xpath("//li[text()='New Playlist']")).click();

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']/input")));
        getDriver().findElement(By.xpath("//form[@name='create-simple-playlist-form']/input")).sendKeys("HomeWork19", Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='HomeWork19']")));
        getDriver().findElement(By.xpath("//a[text()='HomeWork19']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        getDriver().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted playlist')]")));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(),'Deleted playlist')]")).isDisplayed());



    }
}
