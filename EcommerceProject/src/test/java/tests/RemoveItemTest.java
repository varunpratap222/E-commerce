package tests;

import base.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import pages.*;

import utils.ConfigReader;

import java.time.Duration;

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
        String product = detailsPage.getProductName();
        Thread.sleep(4000);

        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/cart"
        );
        Thread.sleep(4000);
        CartPage cart = new CartPage(driver);


        Assert.assertTrue(

                cart.isProductPresent(product)
        );

        cart.removeProduct(product);
        Thread.sleep(1000);
        cart.removeAllProducts();

        Assert.assertTrue(

                cart.isCartEmpty()
        );
    }
}