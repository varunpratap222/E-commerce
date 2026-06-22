package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.ProductPage;

import pages.ProductDetailsPage;

public class ProductDetailsTest

        extends BaseTest {

    @Test

    public void openProductAndValidateDetails()

            throws InterruptedException {

        login();

        ProductPage page =

                new ProductPage(
                        driver
                );

        Thread.sleep(4000);

        page.openFirstProduct(
                "iPhone 17 Pro Max"
        );

        Thread.sleep(4000);

        ProductDetailsPage details =

                new ProductDetailsPage(
                        driver
                );

        Assert.assertEquals(

                details.getProductName(),

                "iPhone 17 Pro Max"
        );

        Assert.assertEquals(

                details.getProductPrice(),

                "₹80000"
        );

        Assert.assertTrue(

                details.isAddToCartVisible()
        );

        Assert.assertTrue(

                details.isBuyNowVisible()
        );
    }
}