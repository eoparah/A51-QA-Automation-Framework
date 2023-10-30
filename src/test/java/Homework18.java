import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        //Navigate to "https://qa.koel.app/".
        launchBrowser();

        // Log in with your credentials.
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        //Steps to validate a song is playing
        playASong();
        Assert.assertTrue(songIsPlaying());
    }
        public void playASong() {
            WebElement playNextSong = driver.findElement(By.cssSelector("i[data-testid=play-next-btn]"));
            playNextSong.click();

            WebElement clickPlay = driver.findElement(By.cssSelector("span[data-testid=play-btn]"));
            clickPlay.click();
        }

        public boolean songIsPlaying() {
            WebElement pauseButtonDisplayed = driver.findElement(By.cssSelector("span[data-testid=pause-btn]"));
            return pauseButtonDisplayed.isDisplayed();
            }

    }



