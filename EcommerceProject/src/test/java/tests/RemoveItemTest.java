package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.*;

import utils.ConfigReader;

public class RemoveItemTest extends BaseTest {

    @Test

    public void removeItemFromCart() throws InterruptedException {

        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/login"
        );
        login();
        Thread.sleep(2000);
        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        Thread.sleep(2000);
        detailsPage.clickAddToCart();
        Thread.sleep(2000);
        detailsPage.acceptAlert();
        Thread.sleep(2000);
        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/cart"
        );
        Thread.sleep(2000);
        String product = detailsPage.getProductName();

        CartPage cart = new CartPage(driver);


        Assert.assertTrue(

                cart.isProductPresent(product)
        );

        cart.removeProduct(product);

        Assert.assertFalse(

                cart.isProductPresent(product)
        );
    }
}