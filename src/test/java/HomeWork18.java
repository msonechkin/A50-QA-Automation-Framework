import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HomeWork18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        Thread.sleep(1500);
        WebElement lamentSong = getDriver().findElement(By.xpath("//td[contains(text(), 'Lament')]"));
        Thread.sleep(1500);

        Actions action = new Actions(getDriver());
        action.doubleClick(lamentSong).perform();
        Thread.sleep(1500);
        Assert.assertEquals(getDriver().findElement(By.xpath("//h3")).getText(), "Lament");



    }
}
