package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.ProductPage;

public class AddToCartTest

        extends BaseTest {

    @Test

    public void addToCartTest() throws InterruptedException {

        login();

        Thread.sleep(2000);
        ProductPage productPage =

                new ProductPage(driver);

        productPage.openFirstProduct(

                "iPhone 17 Pro Max"
        );
        Thread.sleep(2000);

        ProductDetailsPage details =

                new ProductDetailsPage(
                        driver
                );
        Thread.sleep(2000);
        details.clickAddToCart();
        Thread.sleep(4000);
        Assert.assertEquals(

                details.getAlertText(),

                "Added To Cart Successfully \uD83D\uDED2"

        );
        details.acceptAlert();
    }
}
