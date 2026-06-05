package tests;

import base.BaseTest;
import dataprovider.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(email,password);

    }
    @Test(
            dataProvider = "amazonData",
            dataProviderClass =
                    TestDataProvider.class
    )
    public void loginTest(
            String email,
            String password,
            String product) {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//        LoginPage loginPage =
//                new LoginPage(driver);

        loginPage.login(
                email,
                password);
    }
}
