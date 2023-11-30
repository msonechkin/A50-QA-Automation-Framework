import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {

    @Test
    public void registrationNavigation() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.findElement(By.xpath("//a[contains(text(), 'Registration')]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");
        driver.quit();
    }
}
