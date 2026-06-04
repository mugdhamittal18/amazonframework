//package tests;
//
//import base.BaseTest;
//import org.testng.annotations.Test;
//import pages.CartPage;
//import pages.CheckoutPage;
//import pages.HomePage;
//import pages.LoginPage;
//import pages.SearchPage;
//
//public class AmazonOrderTest extends BaseTest {
//
//    @Test
//    public void orderMacBookTest() {
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.login(email, "your_password");
//
//        HomePage homePage = new HomePage(driver);
//
//        homePage.searchProduct("MacBook");
//
//        SearchPage searchPage = new SearchPage(driver);
//
//        searchPage.selectProduct();
//
//        searchPage.addToCart();
//
//        CartPage cartPage = new CartPage(driver);
//
//        cartPage.proceedToCheckout();
//
//        CheckoutPage checkoutPage = new CheckoutPage(driver);
//
//        // Be careful
//        // Uncomment only if needed
//
//        // checkoutPage.placeOrder();
//    }
//}
package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
        import utils.ConfigReader;

public class AmazonOrderTest extends BaseTest {

    @Test
    public void orderMobileTest() throws InterruptedException {

        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");
        String product = ConfigReader.getProperty("product");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(product);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectProduct();
        searchPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // checkoutPage.placeOrder();
    }
}