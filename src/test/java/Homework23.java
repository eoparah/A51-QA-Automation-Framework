import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    /*@Test
    public void deleteAPlayList() throws InterruptedException{
        //Navigate to "https://qa.koel.app/".
        launchBrowser(url);

        // Log in with your credentials.
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        //Steps to delete a Playlist
        openPlaylist();
        deletePlaylist();
        Assert.assertTrue(playListDeleted());
    }*/

    @Test
    public void deleteAPlayList() throws InterruptedException{
        //Navigate to "https://qa.koel.app/".
        LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);

        // Log in with your credentials.

        loginPage.provideEmail("demo@class.com");
                 loginPage.providePassword("te$t$tudent");
                 loginPage.clickSubmit();
        Thread.sleep(2000);

        //Steps to delete a Playlist
        openPlaylist();
        deletePlaylist();
        Assert.assertTrue(playListDeleted());
    }
    public void openPlaylist() {
        //WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }
    public void deletePlaylist() {
        //WebElement xPlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement xPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        xPlaylist.click();
    }
    public boolean playListDeleted(){
        //WebElement playListDeletedNotification = driver.findElement(By.cssSelector("p[class=msg]"));
        WebElement playListDeletedNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class=msg]")));
        return playListDeletedNotification.isDisplayed();
    }
}
