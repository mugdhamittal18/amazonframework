package dataprovider;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;

import static utils.DriverFactory.driver;

public class TestDataProvider {

    @DataProvider(name="amazonData")

    public Object[][] getData()
            throws Exception {

        return ExcelUtils.getData();
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

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                email,
                password);
    }
}