package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.OrderPage;
import utils.ConfigReader;

public class OrderHistoryTest extends BaseTest {

    @Test
    public void verifyOrderHistory() throws InterruptedException {

        login();
        Thread.sleep(2000);
        driver.get(

                ConfigReader.getProperty("baseUrl")

                        + "/my-orders"

        );

        Thread.sleep(2000);

        OrderPage order =

                new OrderPage(driver);
        Thread.sleep(4000);

        Assert.assertTrue(

                order.isPageVisible()

        );
        Thread.sleep(2000);

        Assert.assertTrue(

                order.getOrderCount() > 0,

                "No orders found"

        );
        Thread.sleep(2000);

        Assert.assertTrue(

                order.isStatusDisplayed()

        );


        Assert.assertTrue(

                order.isTotalVisible()

        );

        Assert.assertTrue(

                order.isProductPresent(

                        "iPhone 15"

                )

        );
        Thread.sleep(2000);
    }
}