import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpDriverAndOpen() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
   }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    public void logIn(String email, String password) {
        WebElement emailField = getDriver().findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(password);
        WebElement logInButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();
    }

}