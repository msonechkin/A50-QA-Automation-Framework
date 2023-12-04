import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        enterEmail("andrii.banak@testpro.io");
        enterPassword("OknwxILOM2B3$");
        clickLogInButton();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        Thread.sleep(2000);
        WebElement plutoSong = driver.findElement(By.xpath("//td[contains(text(), 'Pluto')]"));
        plutoSong.click();
        driver.findElement(By.cssSelector(".btn-add-to")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'ololo')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'ololo')]")).click();

        Assert.assertEquals(plutoSong.getAttribute("td"), "Pluto");
    }

}
