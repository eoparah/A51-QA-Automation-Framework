import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

    launchBrowser(url);
    navigateToLoginPage();
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmit();

    WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertEquals(driver.getCurrentUrl(), url);
    driver.quit();
    }

}
