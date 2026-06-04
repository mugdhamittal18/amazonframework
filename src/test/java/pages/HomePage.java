package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");

    public void searchProduct(String productName) {

        WaitUtils wait =
                new WaitUtils(driver);

        wait.waitForVisibility(searchBox)
                .sendKeys(productName);
        //driver.findElement(searchBox).sendKeys(productName);

        driver.findElement(searchButton).click();
    }
}