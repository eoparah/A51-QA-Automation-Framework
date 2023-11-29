import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest()throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail(("demo@class.com"));
        loginPage.providePassword(("te$t$tudent"));
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

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
