package com.qa.koel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork16 extends BaseTest {

    @Test
    @Parameters({"BaseURL"})
    public void registrationNavigation(String BaseURL) {
        Assert.assertEquals(getDriver().getCurrentUrl(),BaseURL);
        getDriver().findElement(By.xpath("//a[contains(text(), 'Registration')]")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://qa.koel.app/registration");


    }

}
