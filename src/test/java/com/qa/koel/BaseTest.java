package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    private WebDriver driver;
    WebDriverWait wait;
    Actions action;
    String playListName;

 @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpDriverAndOpen(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");;

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        playListName = UUID.randomUUID().toString();

    }

    public WebDriver getDriver() {
        return driver;
   }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }


    public void createPlaylist(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        WebElement create = getDriver().findElement(By.xpath("//i[@title='Create a new playlist']"));
        action.click(create).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='New Playlist']")));
        getDriver().findElement(By.xpath("//li[text()='New Playlist']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name='create-simple-playlist-form']/input")));
        getDriver().findElement(By.xpath("//form[@name='create-simple-playlist-form']/input")).sendKeys(name, Keys.ENTER);
    }


}