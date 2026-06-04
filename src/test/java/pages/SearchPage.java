package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    By firstProduct = By.xpath("(//h2[contains(@class,'a-size-medium')]//span)[1]");

    //By firstProduct = By.cssSelector("h2 a");
    By addToCartBtn = By.id("add-to-cart-button");

//    public void selectProduct() throws InterruptedException {
//
//        Thread.sleep(3000);
//        driver.findElement(firstProduct).click();
//    }
//    public void selectProduct() {
//        String parentWindow = driver.getWindowHandle();
//        driver.findElement(firstProduct).click();
//        // Switch to newly opened window
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(parentWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//    }
    public void selectProduct() {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(firstProduct).click();
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void addToCart() {
        System.out.println("Amazon Current URL Title: "+driver.getCurrentUrl());

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement addToCart =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.id("add-to-cart-button")));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        addToCart);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        addToCart);
    }
//    public void addToCart() {
//        System.out.println("Amazon URL Title: "+driver.getTitle());
//        System.out.println("Amazon Current URL Title: "+driver.getCurrentUrl());
//        //driver.findElement(addToCartBtn).click();
//        WebDriverWait wait =
//                new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement addToCart =
//                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
//
//        addToCart.click();
//    }
//    public void addToCart() {
//
//        for(String tab : driver.getWindowHandles()) {
//            driver.switchTo().window(tab);
//        }
//
//        driver.findElement(addToCartBtn).click();
//    }
}
