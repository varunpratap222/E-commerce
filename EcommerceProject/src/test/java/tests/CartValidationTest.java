package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;

import utils.ConfigReader;

public class CartValidationTest extends BaseTest {

    @Test
    public void validateCart() throws InterruptedException {

        login();
        Thread.sleep(4000);
        ProductDetailsPage details =

                new ProductDetailsPage(driver);

        details.openCart();
        Thread.sleep(4000);
        CartPage cart =

                new CartPage(driver);

        Assert.assertTrue(

                cart.isCartVisible()

        );

        Assert.assertTrue(

                cart.isTotalVisible()

        );

        Assert.assertTrue(

                cart.isCheckoutVisible()

        );
    }

    public int getQuantity(String productName){

        String xpath =
                "//h3[text()='"+productName+"']" +
                        "/following::div[contains(@style,'gap: 15px')][1]/span";

        return Integer.parseInt(
                driver.findElement(
                        By.xpath(xpath)
                ).getText()
        );
    }
    public void increaseQuantity(String productName){

        String xpath =
                "//h3[text()='"+productName+"']" +
                        "/following::button[text()='+'][1]";

        driver.findElement(
                By.xpath(xpath)
        ).click();
    }
    public void decreaseQuantity(String productName){

        String xpath =
                "//h3[text()='"+productName+"']" +
                        "/following::button[text()='-'][1]";

        driver.findElement(
                By.xpath(xpath)
        ).click();
    }
}