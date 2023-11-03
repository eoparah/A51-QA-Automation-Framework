import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {


    @Test
    public void renamePlaylist() throws InterruptedException {

        //Navigate to "https://qa.koel.app/".
        launchBrowser(url);

        //Login
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        //Right click "Playlist" and click "Edit"
        contextClickPlayList();

        //Rename and press "Enter"
        fieldPlaylist();

        //Assertion= new Playlist name displayed
        //boolean playListDisplayed;
       Assert.assertTrue(playListDisplayed());
    }
        public void contextClickPlayList(){
        WebElement contextCLickPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"#!/playlist/74521\"]")));
        actions.contextClick(contextCLickPlayList).perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid=\"playlist-context-menu-edit-74521\"]")));
            actions.click();
        }
        public void fieldPlaylist() throws InterruptedException {
        //WebElement playListName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test=\"new-playlist-name\"]")));
            WebElement playListName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            playListName.sendKeys(Keys.CONTROL, "xx");
        playListName.sendKeys(Keys.ENTER);
        }
        public boolean playListDisplayed() {
        WebElement showPlaylist = driver.findElement(By.xpath("//a[text()='xx']"));
        return showPlaylist.isDisplayed();}
     }