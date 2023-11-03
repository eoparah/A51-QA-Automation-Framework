import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver = null;

    public String url = "https://qa.koel.app/";

    public WebDriverWait wait;

    public Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions (driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public void navigateToLoginPage() {
        driver.get(url);
    }
    public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }
}