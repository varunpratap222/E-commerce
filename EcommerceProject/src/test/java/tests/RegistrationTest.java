package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void validRegistrationTest() {

        driver.get("http://localhost:5173/register");

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        String email =
                "varun" + System.currentTimeMillis()
                        + "@gmail.com";

        registrationPage.register(
                "Varun",
                email,
                "Password@123"
        );

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains("login")
        );

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("login")
        );
    }
}