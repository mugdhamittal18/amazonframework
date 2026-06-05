package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static ThreadLocal<WebDriver>
            driver = new ThreadLocal<>();
    //private static WebDriver driver;

    public static void initDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        switch(browser.toLowerCase()) {

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                //driver = new FirefoxDriver();

                break;

            case "edge":

                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                //driver = new EdgeDriver();

                break;

            default:

                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                //driver = new ChromeDriver();
        }
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
        //return driver;
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}