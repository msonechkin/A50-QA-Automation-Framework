import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {

        logIn("andrii.banak@testpro.io", "OknwxILOM2B3$");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'All Songs')]")));
        getDriver().findElement(By.xpath("//a[contains(text(), 'All Songs')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Lament')]")));
        getDriver().findElement(By.xpath("//td[contains(text(), 'Lament')]")).click();
        getDriver().findElement(By.cssSelector(".btn-add-to")).click();

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'ololo')]")));
        getDriver().findElement(By.xpath("//li[contains(text(), 'ololo')]")).click();

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'ololo')]")));
        WebElement button = getDriver().findElement(By.xpath("//a[contains(text(), 'ololo')]"));
        Actions action = new Actions(getDriver());
        action.click(button).perform();


        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")));
        assertEquals(getDriver().findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), 'Lament')]")).getText(), "Lament");

    }

}
