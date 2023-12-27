package com.qa.koel.stepdefenition;

import com.qa.koel.HomePage;
import com.qa.koel.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginStepDefenition {
    private WebDriver driver;
    protected String url = "https://qa.koel.app/";
    Actions action;
    public WebDriver getDriver() {
        return this.driver;
    }
    @Before
    public void setUpDriverAndOpen() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  //Added ChromeOptions argument below to fix websocket error
        driver = new ChromeDriver(options);
        driver.get(url);
    }



    @When("I login as user in Koel with {string} and {string}")
    public void loginAsUserWithCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn(email, password);
    }

    @Then("I should be authorized in home page")
    public void iShouldBeAuthorized() {
        HomePage homePage = new HomePage(getDriver());
        homePage.waitUntilVisibilityOfElement(homePage.getLogOutButton(), 6);
        Assert.assertTrue(homePage.getLogOutButton().isDisplayed());
    }

    @After
    public void closeDriver() {
        getDriver().quit();
    }
}
