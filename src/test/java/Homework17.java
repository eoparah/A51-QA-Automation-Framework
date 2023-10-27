import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //Navigate to "https://qa.koel.app/".
        launchBrowser();

        // Log in with your credentials.
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$tStudent");
        clickSubmit();
        Thread.sleep(2000);
        searchASong("Ketsa");
        viewAll();
        selectFirstSong();
        addToPlaylist();
        choosePlaylist();
        getNotificationText();
    }

      //Search for a song (choose any song of your choice).
        public void searchASong (String songTitle) throws InterruptedException{
            WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
            searchField.sendKeys(songTitle);
            Thread.sleep(2000);
        }
        //Click 'View All' button to display the search results
        public void viewAll () throws InterruptedException{
            WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test=\"view-all-songs-btn\"]"));
            viewAllButton.click();
            Thread.sleep(2000);
        }
        //Click the first song in the search results.
        public void selectFirstSong() throws InterruptedException{
            WebElement firstSongResult = driver.findElement(By.cssSelector("div[class=\"song-list-wrap main-scroll-wrap search-results\"]"));
            firstSongResult.click();
            Thread.sleep(2000);
        }
        //Click 'ADD TO...' button.
        public void addToPlaylist() throws InterruptedException{
            WebElement addSongToPlaylist = driver.findElement(By.cssSelector("button[class=\"btn-add-to\"]"));
            addSongToPlaylist.click();
            Thread.sleep(2000);
        }
        //Choose the playlist to add it to, (you can create a new one with a unique name)
        public void choosePlaylist() throws InterruptedException{
            WebElement selectedPlaylist = driver.findElement(By.cssSelector("li[class=\"playlist playlist\"]"));
            selectedPlaylist.click();
            Thread.sleep(2000);
        }
        //Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
        public String getNotificationText(){
            WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
            return notificationElement.getText();
        }
}


