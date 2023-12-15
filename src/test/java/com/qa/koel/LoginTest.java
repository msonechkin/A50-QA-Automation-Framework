package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    @Parameters({"BaseURL"})
    public void loginEmptyEmailPassword(String BaseURL) {
        loginPage = new LoginPage(getDriver());

        loginPage.getLoginButton().click();
        Assert.assertEquals(getDriver().getCurrentUrl(), BaseURL);

    }
    @Test
    @Parameters({"BaseURL"})
    public void registrationNavigation(String BaseURL) {
        loginPage = new LoginPage(getDriver());

        Assert.assertEquals(getDriver().getCurrentUrl(),BaseURL);
        loginPage.getRegistrationButton().click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://qa.koel.app/registration");


    }
}
