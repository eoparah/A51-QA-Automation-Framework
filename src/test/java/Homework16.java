import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends LoginTests {

    @Test
    public void registrationNavigation() {

        //Pre-Conditions

        Webdriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitWait(new Duration(2000));

        //Using Selenium, navigate to "https://qa.koel.app/".//
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Click the Registration link.//
        Webelement registrationField = driver.findELement(By.cssSelector("div a[href='registration']"));
        registrationField.click();

        //Verify that you are redirected to Registration page using Assert method.//
        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();

    }
}
