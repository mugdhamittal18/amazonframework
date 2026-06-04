package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        driver =
                DriverFactory.getDriver();

        driver.get(
                ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
//    @BeforeMethod
//    public void setup() {
//
//        driver = DriverFactory.initializeDriver();
//
//        driver.get("https://www.amazon.in");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//    }
//
//    @AfterMethod
//    public void tearDown() {
//
//        if(driver != null) {
//            driver.quit();
//        }
//    }
}