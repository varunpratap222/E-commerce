package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class ProductDetailsPage {

    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;
    }

    private By productName =
            By.xpath("//h3");

    private By productPrice =
            By.xpath("//p[contains(text(),'₹')]");

    private By buyNowBtn =
            By.xpath("//button[contains(text(),'Buy Now')]");

    private By addToCartBtn =

            By.xpath(
                    "//button[contains(text(),'Add To Cart')]"
            );

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public String getAlertText() {

        WebDriverWait wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(10)
                );

        Alert alert = wait.until(

                ExpectedConditions

                        .alertIsPresent()

        );

        return alert.getText();
    }

    public void acceptAlert() {

        driver.switchTo()

                .alert()

                .accept();
    }

    public String getProductName() {

        return driver.findElement(
                productName
        ).getText();
    }

    public String getProductPrice() {

        return driver.findElement(
                productPrice
        ).getText();
    }

    public boolean isAddToCartVisible() {

        return driver.findElement(
                addToCartBtn
        ).isDisplayed();
    }

    public boolean isBuyNowVisible() {

        return driver.findElement(
                buyNowBtn
        ).isDisplayed();
    }

    public void openCart() {

        driver.get(

                ConfigReader.getProperty("baseUrl")
                        + "/cart"

        );
    }
}