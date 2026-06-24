package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductDetailsPage;
import pages.CartPage;
import pages.CheckoutPage;

import utils.ConfigReader;

public class EndToEndPurchaseTest extends BaseTest {

    @Test
    public void purchaseFlow() throws InterruptedException {

        // LOGIN

        login();
        Thread.sleep(2000);

        // PRODUCT PAGE
        Thread.sleep(2000);
        ProductPage product =

                new ProductPage(driver);

        product.searchProduct(

                "iPhone 15"

        );

        product.openProduct(

                "iPhone 15"

        );

        Thread.sleep(2000);
        // PRODUCT DETAILS

        ProductDetailsPage details =

                new ProductDetailsPage(driver);
        Thread.sleep(2000);
        details.clickAddToCart();
        Thread.sleep(2000);

        details.acceptAlert();
        Thread.sleep(2000);

        details.openCart();
        Thread.sleep(2000);

        // CART

        CartPage cart =

                new CartPage(driver);

        Assert.assertTrue(

                cart.isProductPresent(

                        "iPhone 15"

                )

        );
        Thread.sleep(2000);

        cart.clickCheckout();

        Thread.sleep(2000);
        // CHECKOUT

        CheckoutPage checkout =

                new CheckoutPage(driver);


        checkout.enterFullName(

                "Varun Pratap"

        );

        checkout.enterPhone(

                "9876543210"

        );

        checkout.enterCity(

                "Delhi"

        );

        checkout.enterState(

                "Delhi"

        );

        checkout.enterPincode(

                "110001"

        );

        checkout.enterAddress(

                "Sector 21"

        );
        Thread.sleep(2000);

        checkout.clickPlaceOrder();

        Thread.sleep(2000);
        Assert.assertEquals(

                checkout.getAlertText(),

                "Order Placed Successfully \uD83C\uDF89"

        );

        Thread.sleep(2000);
        checkout.acceptAlert();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'Back To Products')]")).click();

        // LOGOUT
        HomePage home =

                new HomePage(driver);

        home.clickLogout();

        Thread.sleep(2000);

        Assert.assertTrue(

                driver.getCurrentUrl()

                        .contains("login")

        );
    }
}