import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test
    @Parameters({"BaseURL"})
    public void deletePlaylist(String BaseURL) throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(),BaseURL);

        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
        getDriver().findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")));
        getDriver().findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")).click();
        getDriver().findElement(By.xpath("//form[@name='create-simple-playlist-form']/input")).sendKeys("HomeWork19", Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='HomeWork19']")));
        getDriver().findElement(By.xpath("//a[text()='HomeWork19']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        getDriver().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Deleted playlist')]")));

        Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(),'Deleted playlist')]")).isDisplayed());



    }
}
