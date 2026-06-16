package tests;

import base.BaseTest;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() throws InterruptedException {

        driver.get("http://localhost:5173/login");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "User@test.com",
                "wrongpassword"
        );
        Thread.sleep(3000);

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid credentials"
        );

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("login")
        );




    }
}