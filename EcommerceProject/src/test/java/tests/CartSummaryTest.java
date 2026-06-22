package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

import utils.ConfigReader;

public class CartSummaryTest extends BaseTest {

    @Test

    public void validateCartSummary(){

        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/login"
        );

        login();

        CartPage cart =

                new CartPage(driver);

        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/cart"
        );

        String product = "iPhone 15";

        int price =

                cart.getProductPrice(product);

        int quantity =

                cart.getQuantity(product);

        int subtotal =

                cart.getSubtotal(product);

        Assert.assertEquals(

                subtotal,

                price * quantity

        );

        Assert.assertTrue(

                cart.getTotalAmount() > 0

        );
    }
}