package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class QuantityTest extends BaseTest {

    @Test
    public void verifyIncreaseQuantity() throws InterruptedException {
        login();
        Thread.sleep(2000);
        ProductPage productPage =
                new ProductPage(driver);
        Thread.sleep(2000);
        productPage.openProduct(
                "iPhone 15"
        );
        Thread.sleep(2000);
        ProductDetailsPage detailsPage =
                new ProductDetailsPage(driver);

        detailsPage.clickAddToCart();
        Thread.sleep(2000);
        detailsPage.acceptAlert();
        Thread.sleep(2000);
        detailsPage.openCart();
        Thread.sleep(2000);
        detailsPage.openCart();
        Thread.sleep(2000);
        CartPage cartPage =
                new CartPage(driver);

        int before =
                cartPage.getQuantity(
                        "iPhone 15"
                );

        cartPage.increaseQuantity(
                "iPhone 15"
        );

        int after =
                cartPage.getQuantity(
                        "iPhone 15"
                );

        Assert.assertEquals(
                after,
                before + 1
        );
    }


    @Test
    public void verifyDecreaseQuantity() throws InterruptedException {
        Thread.sleep(2000);
        login();
        Thread.sleep(2000);
        ProductPage productPage =
                new ProductPage(driver);
        Thread.sleep(2000);
        productPage.openProduct(
                "iPhone 15"
        );
        Thread.sleep(2000);
        ProductDetailsPage detailsPage =
                new ProductDetailsPage(driver);
        Thread.sleep(2000);
        detailsPage.openCart();
        Thread.sleep(2000);
        CartPage cartPage =
                new CartPage(driver);
        Thread.sleep(2000);
        int before =
                cartPage.getQuantity(
                        "iPhone 15"
                );
        Thread.sleep(2000);
        if(before > 1){

            cartPage.decreaseQuantity( "iPhone 15");

            int after =
                    cartPage.getQuantity(
                            "iPhone 15"
                    );

            Assert.assertEquals(
                    after,
                    before - 1
            );
        }
    }
}