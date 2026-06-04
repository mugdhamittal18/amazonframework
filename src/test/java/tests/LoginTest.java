package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email,password);

    }



}
