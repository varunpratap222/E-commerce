package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductPage;
import pages.CheckoutPage;

public class CheckoutInitiationTest extends BaseTest {

    @Test
    public void verifyCheckoutInitiation() throws InterruptedException {

        login();
        Thread.sleep(2000);
        HomePage home =

                new HomePage(driver);

        Thread.sleep(2000);
        ProductPage product =

                new ProductPage(driver);

        Thread.sleep(2000);
        product.openProduct("iPhone 15");

        Thread.sleep(2000);
        ProductDetailsPage details =

                new ProductDetailsPage(driver);

        Thread.sleep(2000);
        details.clickAddToCart();
        Thread.sleep(2000);
        details.acceptAlert();
        Thread.sleep(2000);
        details.openCart();
        Thread.sleep(2000);

        CartPage cart =

                new CartPage(driver);

        Thread.sleep(2000);
        cart.proceedToCheckout();

        Thread.sleep(2000);
        CheckoutPage checkout =

                new CheckoutPage(driver);

        Thread.sleep(2000);
        Assert.assertTrue(

                checkout.isCheckoutPageOpened()

        );
        Thread.sleep(2000);

        checkout.fillCheckoutForm(
                "Varun Pratap",
                "9876543210",
                "Gurgaon",
                "Haryana",
                "122001",
                "Sector 21, Gurgaon"
        );
        Thread.sleep(2000);
        checkout.selectPaymentMethod("UPI");
        checkout.clickPlaceOrder();
        Thread.sleep(2000);
        details.acceptAlert();

    }
}