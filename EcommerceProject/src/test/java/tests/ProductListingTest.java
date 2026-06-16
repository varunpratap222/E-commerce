package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductListingTest extends BaseTest{
    @Test

    public void validateProductVisibility()

            throws InterruptedException {

        login();

        Thread.sleep(3000);

        ProductPage page =

                new ProductPage(driver);

        Assert.assertTrue(

                page.getProductCount() > 0,

                "No products found"
        );

        System.out.println(

                "Products found : "

                        + page.getProductCount()
        );
    }

    @Test
    public void validateProductDetails() {

        login();

        ProductPage page =
                new ProductPage(driver);

        for(WebElement product :

                page.getProductNames()) {

            Assert.assertFalse(

                    product.getText()
                            .trim()
                            .isEmpty(),

                    "Product name missing"
            );
        }

        for(WebElement price :

                page.getProductPrices()) {

            Assert.assertTrue(

                    price.getText()
                            .contains("₹"),

                    "Price missing"
            );
        }

        for(WebElement image :

                page.getProductImages()) {

            Assert.assertTrue(

                    image.isDisplayed(),

                    "Image missing"
            );
        }
    }


    @Test

    public void ValidateProductNames()

            throws InterruptedException {

        login();

        Thread.sleep(3000);

        ProductPage page =

                new ProductPage(driver);

        for(WebElement product :

                page.getProductNames()){

            Assert.assertFalse(

                    product.getText()
                            .trim()
                            .isEmpty(),

                    "Product name missing"
            );

            System.out.println(

                    product.getText()
            );
        }
    }

    @Test

    public void searchProductTest() {

        login();

        ProductPage page =

                new ProductPage(driver);

        page.searchProduct("Samsung");

        Assert.assertTrue(

                driver.getPageSource()

                        .contains("Samsung")

        );
    }

}
