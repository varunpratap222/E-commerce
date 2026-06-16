package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.getDriver();

        driver.get(
                ConfigReader.getProperty(
                        "baseUrl"
                )
        );
    }
    protected void login() {

        driver.get(
                "http://localhost:5173/login"
        );

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(

                ConfigReader.getProperty("email"),

                ConfigReader.getProperty("password")
        );
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}