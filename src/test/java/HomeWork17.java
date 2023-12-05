import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        Thread.sleep(1500);
        WebElement lamentSong = getDriver().findElement(By.xpath("//td[contains(text(), 'Lament')]"));
        lamentSong.click();
        getDriver().findElement(By.cssSelector(".btn-add-to")).click();
        getDriver().findElement(By.xpath("//li[contains(text(), 'ololo')]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//a[contains(text(), 'ololo')]")).click();
        Thread.sleep(2000);
        assertEquals(getDriver().findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")).getText(), "Lament");

    }

}
