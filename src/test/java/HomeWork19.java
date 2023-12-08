import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test
    @Parameters({"BaseURL"})
    public void deletePlaylist(String BaseURL) throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(),BaseURL);

        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//form[@name='create-simple-playlist-form']/input")).sendKeys("HomeWork19", Keys.ENTER);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[text()='HomeWork19']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(),'Deleted playlist')]")).isDisplayed());



    }
}
