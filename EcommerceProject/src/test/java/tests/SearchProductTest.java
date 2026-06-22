package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.ProductPage;

public class SearchProductTest

        extends BaseTest {

    @Test

    public void searchProductTest()

            throws InterruptedException {

        login();

        Thread.sleep(10000);

        ProductPage page =

                new ProductPage(driver);

        page.searchProduct(
                "Samsung"
        );
        Thread.sleep(3000);


        Assert.assertTrue(

                page.isProductVisible(
                        "Samsung S24"
                ),

                "Search failed"
        );
    }
}