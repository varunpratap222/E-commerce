package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;

public class CheckoutValidationTest extends BaseTest {

    @Test

    public void validateCheckoutInputs(){

        driver.get(

                "http://localhost:5173/checkout"

        );

        CheckoutPage checkout =

                new CheckoutPage(driver);


        checkout.enterName(

                "Varun Pratap"

        );

        checkout.enterAddress(

                "Delhi"
        );

        checkout.enterPhone(

                "9876543210"
        );


        Assert.assertEquals(

                driver.findElement(

                        org.openqa.selenium.By.name("name")

                ).getAttribute("value"),

                "Varun Pratap"
        );
    }
}