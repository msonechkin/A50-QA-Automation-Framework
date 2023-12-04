import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
