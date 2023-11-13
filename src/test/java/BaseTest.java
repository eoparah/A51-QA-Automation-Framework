import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    //public String url = "https://qa.koel.app/";
    public static String url = null;
    public static WebDriverWait wait =null;
    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = pickBrowser(System.getProperty("browser"));

        //driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions (driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;

    }
        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://10.0.0.206.4444";

            switch (browser){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return driver = new FirefoxDriver();
                case "MicrosoftEdge":
                    WebDriverManager.chromedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    return driver = new EdgeDriver(edgeOptions);

                    //Selenium Grid
                case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                    caps.setCapability("browser", "MicrosoftEdge");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                    caps.setCapability("browserName", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                case "cloud":
                    return lambdaTest();

                    default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                    return driver = new ChromeDriver(options);
            }
        }
        public WebDriver lambdaTest() {
            String username = "esther.oparah";
            String authKey = "jwE0Z2xM7ZJt0cCF7rh66Vt2irsFcOuBJ9Iglr28PKxN6n1znc";
            String hub = "@hub.lambdatest.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("version", "120.0");
            caps.setCapability("resolution", "12024x768");
            caps.setCapability("build", "TestNG with Java");
            caps.setCapability("name", this.getClass().getName());
            caps.setCapability("plugin", "java-testNG");

            return new RemoteWebDriver(new URL("https://" +username+ ":" +authKey + hub), caps);

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