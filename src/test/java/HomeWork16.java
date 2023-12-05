import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

        getDriver().findElement(By.xpath("//a[contains(text(), 'Registration')]")).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://qa.koel.app/registration");

    }
}
