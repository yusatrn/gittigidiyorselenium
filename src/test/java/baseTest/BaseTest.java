package baseTest;

import base.BasePage;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Locale;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;


public class BaseTest {
    public static WebDriver driver;
    public   static WebDriverWait wait;
    final static Logger logger = Logger.getLogger(BaseTest.class.getName());
    public enum OSType {
        Windows, MacOS, Linux, Other
    };
    protected static OSType detectedOS;
    @BeforeClass
    public static void setUp(){

        PropertyConfigurator.configure("src/main/resources/ log4j.properties");


        if (getOperatingSystemType().toString()=="Windows") {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 1);
            driver.get("https://www.gittigidiyor.com/");
            logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        }
        if (getOperatingSystemType().toString()=="MacOS") {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_mac");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 1);
            driver.get("https://www.gittigidiyor.com/");
            logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        }
        if (getOperatingSystemType().toString()=="Linux") {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 1);
            driver.get("https://www.gittigidiyor.com/");
            logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        }

    }
    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
            } else if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
            } else if (OS.indexOf("nux") >= 0) {
                detectedOS = OSType.Linux;
            } else {
                detectedOS = OSType.Other;
            }
        }
        return detectedOS;
    }
    @AfterClass
    public static void tearDownn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.quit();
        TimeUnit.SECONDS.sleep(2);
    }
    @After
    public void tearDown(){


        driver.close();

    }
}
