package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartBtn = By.id("nav-cart");
    By proceedToBuy = By.name("proceedToRetailCheckout");
    public void proceedToCheckout() throws InterruptedException {

        driver.findElement(cartBtn).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.urlContains("cart"));

        wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.name("proceedToRetailCheckout")))
                .click();
        Thread.sleep(5000);
    }
//    public void proceedToCheckout() {
//
//        driver.findElement(cartBtn).click();
//
//        driver.findElement(proceedToBuy).click();
//    }
}