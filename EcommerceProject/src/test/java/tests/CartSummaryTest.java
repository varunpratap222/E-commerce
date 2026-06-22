package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

import utils.ConfigReader;

public class CartSummaryTest extends BaseTest {

    @Test

    public void validateCartSummary() throws InterruptedException {

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
        String product = detailsPage.getProductName();
        Thread.sleep(2000);
        CartPage cart =

                new CartPage(driver);
        Thread.sleep(2000);
        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/cart"
        );
        Thread.sleep(2000);
        int price =

                cart.getProductPrice(product);

        int quantity =

                cart.getQuantity(product);

        int subtotal =

                cart.getSubtotal(product);

        int total =
                cart.getTotalAmount();


        System.out.println("========== CART SUMMARY ==========");
        System.out.println("Product Name : " + product);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Subtotal     : " + subtotal);
        System.out.println("Total Amount : " + total);
        System.out.println("=================================");

        Assert.assertEquals(

                subtotal,

                price * quantity

        );

        Assert.assertTrue(

                cart.getTotalAmount() > 0

        );
    }
}