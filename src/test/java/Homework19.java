import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
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
    }
    public void openPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("li[class=playlist]"));
        playlist.click();
    }
    public void deletePlaylist() {
        WebElement xPlaylist = driver.findElement(By.cssSelector("button[title=Delete this playlist]"));
        xPlaylist.click();
        }
    public boolean playListDeleted(){
        WebElement playListDeletedNotification = driver.findElement(By.cssSelector("p[class=msg]"));
        return playListDeletedNotification.isDisplayed();
        }
    }



