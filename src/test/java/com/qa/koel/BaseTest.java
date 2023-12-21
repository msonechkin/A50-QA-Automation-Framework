package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    private WebDriver driver;
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    Actions action;


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpDriverAndOpen(String BaseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickDriver(System.getProperty("browserName")));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().get(BaseURL);
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        action = new Actions(THREAD_LOCAL.get());

    }

    public WebDriver getDriver() {
        return THREAD_LOCAL.get();
   }

    @AfterMethod
    public void closeDriver() {
        THREAD_LOCAL.get().quit();
    }

    public WebDriver pickDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://192.168.0.6:4444/";
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");  //Added ChromeOptions argument below to fix websocket error
                return new ChromeDriver(options);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return  driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            case "lambda-driver":
                return  getLambdaDriver();
            default:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
        }
    }

    public  WebDriver getLambdaDriver() throws MalformedURLException {
        String userName = "mark.sonechkin";
        String authKey = "1vrTtjvjY289FiYdsXVSgiAhxW9r1v6lWFszc2JeSof53m6kqH";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "121.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", authKey);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Koel");
        capabilities.setCapability("LT:Options", ltOptions);
        return  new RemoteWebDriver(URI.create("https://" + userName + ":" + authKey + hub).toURL(), capabilities);
    }
}