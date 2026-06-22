package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductPage;

import static sun.security.jgss.GSSUtil.login;
import static utils.DriverFactory.driver;

public class CartTest extends BaseTest {

    @Test
    public void validateCart() throws InterruptedException {

        login();
        Thread.sleep(2000);
        ProductPage page =

                new ProductPage(driver);

        page.openFirstProduct(
                "iPhone 17 Pro Max"
        );
        Thread.sleep(2000);

        ProductDetailsPage details =

                new ProductDetailsPage(driver);

        Thread.sleep(2000);
        details.clickAddToCart();
        Thread.sleep(2000);
        details.acceptAlert();
        Thread.sleep(2000);
        CartPage cart =

                new CartPage(driver);

        Assert.assertTrue(

                cart.isProductPresent(

                        "iPhone 17 Pro Max"

                )

        );
        Thread.sleep(2000);
        Assert.assertTrue(

                cart.getCartSize() > 0

        );
    }
}