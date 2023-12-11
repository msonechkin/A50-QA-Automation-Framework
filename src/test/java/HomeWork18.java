import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HomeWork18 extends BaseTest{
    @Test
    public void playSong(){
        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'All Songs')]")));
        getDriver().findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Lament')]")));
        WebElement lamentSong = getDriver().findElement(By.xpath("//td[contains(text(), 'Lament')]"));

        Actions action = new Actions(getDriver());
        action.doubleClick(lamentSong).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        Assert.assertEquals(getDriver().findElement(By.xpath("//h3")).getText(), "Lament");



    }
}
