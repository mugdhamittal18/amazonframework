package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class SearchTest extends BaseTest {

    @Test
    public void verifySearchResults() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchProduct("MacBook Air");

        String title =
                driver.getTitle();

        Assert.assertTrue(
                title.contains("MacBook"),
                "Search results not displayed");
    }
}