package dataprovider;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ExcelUtils;
public class TestDataProvider {

    @DataProvider(name="amazonData")

    public Object[][] getData()
            throws Exception {

        return ExcelUtils.getData();
    }

}