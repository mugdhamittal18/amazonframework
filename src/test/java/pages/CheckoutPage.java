package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By placeOrderBtn = By.name("placeYourOrder1");

    public void placeOrder() {

        // CAUTION
        // This actually places order

        driver.findElement(placeOrderBtn).click();
    }
}