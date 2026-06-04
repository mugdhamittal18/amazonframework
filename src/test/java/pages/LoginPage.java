package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    // Locators
   // By signInBtn = By.xpath("//a[@data-nav-role='signin']");
    By signInBtn = By.id("nav-link-accountList");
    By emailField = By.id("ap_email_login");
    By continueBtn = By.xpath("//*[@id=\"continue\"]/span/input");
    //id("continue");
    By passwordField = By.id("ap_password");
    By loginBtn = By.id("signInSubmit");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login Method
    public void login(String email, String password) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Sign In
        wait.until(
                        ExpectedConditions.elementToBeClickable(signInBtn))
                .click();

        // Wait for Email Field
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField));

        // Enter Email
        driver.findElement(emailField)
                .sendKeys(email);

        // Click Continue
        wait.until(
                        ExpectedConditions.elementToBeClickable(continueBtn))
                .click();

        // Wait for Password Field
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField));

        // Enter Password
        driver.findElement(passwordField)
                .sendKeys(password);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Click Login
        wait.until(
                        ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
            try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}