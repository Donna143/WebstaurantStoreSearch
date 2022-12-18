package pageObjectTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected String url;
    protected String USERNAME = "thebestlifeever_OH80xE";
    protected String AUTOMATE_KEY = "zvfa6sUsD8KeXkFhnsC4";
    protected String BSURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void startUp() throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        url = "https://www.webstaurantstore.com";

//        MutableCapabilities capabilities = new MutableCapabilities();
//        capabilities.setCapability("browserName", "Chrome");
//        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//        browserstackOptions.put("os", "Windows");
//        browserstackOptions.put("osVersion", "10");
//        browserstackOptions.put("browserVersion", "latest");
//        browserstackOptions.put("projectName", "WebstaurantStore");
//        browserstackOptions.put("buildName", "Technical Assessment");
//        browserstackOptions.put("sessionName", "Search");
//        browserstackOptions.put("local", "false");
//        browserstackOptions.put("seleniumVersion", "3.141.59");
//        capabilities.setCapability("bstack:options", browserstackOptions);
//
//        driver = new RemoteWebDriver(new URL(BSURL), capabilities);
//        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){ driver.quit(); }
}
