import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        enterEmail("andrii.banak@testpro.io");
        enterPassword("OknwxILOM2B3$");
        clickLogInButton();

        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        Thread.sleep(1500);
        WebElement lamentSong = driver.findElement(By.xpath("//td[contains(text(), 'Lament')]"));
        lamentSong.click();
        driver.findElement(By.cssSelector(".btn-add-to")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'ololo')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'ololo')]")).click();
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")).getText(), "Lament");

    }

}
