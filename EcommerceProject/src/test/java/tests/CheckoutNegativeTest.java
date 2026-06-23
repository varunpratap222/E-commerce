package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;

public class CheckoutNegativeTest extends BaseTest {

    @Test
    public void verifyEmptyCheckout() throws InterruptedException {
        login();
        Thread.sleep(2000);
        driver.get(

                "http://localhost:5173/checkout"
        );

        CheckoutPage checkout =

                new CheckoutPage(driver);
        Thread.sleep(2000);
        checkout.clickPlaceOrder();

        Thread.sleep(2000);
        Assert.assertEquals(

                checkout.getAlertText(),
                "Please fill all address details ❌"
        );
        Thread.sleep(2000);
        checkout.acceptAlert();


    }

    @Test
    public void verifyInvalidPhone() throws InterruptedException {
        login();
        Thread.sleep(2000);
        driver.get(

                "http://localhost:5173/checkout"
        );
        Thread.sleep(2000);
        CheckoutPage checkout =

                new CheckoutPage(driver);

        checkout.enterFullName(

                "Varun"
        );

        checkout.enterPhone(

                "abc123"
        );

        checkout.enterCity(

                "Delhi"
        );

        checkout.enterState(

                "Haryana"
        );

        checkout.enterPincode(

                "132001"
        );

        checkout.enterAddress(

                "Sector 5"
        );

        checkout.clickPlaceOrder();

        Thread.sleep(2000);
        Assert.assertEquals(

                checkout.getAlertText(),
                "Checkout Failed ❌"
        );
        Thread.sleep(2000);
        checkout.acceptAlert();
    }
    @Test

    public void verifyEmptyPincode() throws InterruptedException {

        login();
        Thread.sleep(2000);
        driver.get(

                "http://localhost:5173/checkout"
        );
        Thread.sleep(2000);
        CheckoutPage checkout =

                new CheckoutPage(driver);
        Thread.sleep(2000);
        checkout.enterFullName(

                "Varun"
        );

        checkout.enterPhone(

                "9876543210"
        );

        checkout.enterCity(

                "Delhi"
        );

        checkout.enterState(

                "Haryana"
        );

        checkout.enterAddress(

                "Sector 5"
        );

        checkout.clickPlaceOrder();
        Thread.sleep(2000);
        Assert.assertEquals(

                checkout.getAlertText(),
                "Please fill all address details ❌"
        );
        Thread.sleep(2000);
        checkout.acceptAlert();
    }
    @Test

    public void verifyUPISelection() throws InterruptedException {
        login();
        Thread.sleep(2000);
        driver.get(

                "http://localhost:5173/checkout"
        );
        Thread.sleep(2000);
        CheckoutPage checkout =

                new CheckoutPage(driver);
        Thread.sleep(2000);
        checkout.selectUPI();
        Thread.sleep(2000);

        Assert.assertTrue(

                checkout.isUPISelected()
        );
    }
}