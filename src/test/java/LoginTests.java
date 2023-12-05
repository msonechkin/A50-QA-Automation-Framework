import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        WebElement logInButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
