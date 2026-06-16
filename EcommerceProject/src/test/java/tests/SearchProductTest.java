package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

import static sun.security.jgss.GSSUtil.login;

public class SearchProductTest extends BaseTest{
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
