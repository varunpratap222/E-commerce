package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        driver.get("http://localhost:5173/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.urlContains("products")
        );

        System.out.println("After Login URL: "
                + driver.getCurrentUrl());

        HomePage homePage = new HomePage(driver);

        homePage.clickLogout();

        wait.until(
                ExpectedConditions.urlContains("login")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login")
        );
    }
}