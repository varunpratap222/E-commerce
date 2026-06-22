package pages;

import org.openqa.selenium.*;
import java.util.List;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){

        this.driver = driver;
    }

    private By products =

            By.xpath("//button[text()='Add To Cart']/ancestor::div[1]");

    private By productNames =

            By.tagName("h3");

    private By productPrices =

            By.xpath("//p[contains(text(),'₹')]");

    private By addToCartButtons =

            By.xpath("//button[text()='Add To Cart']");

    private By productImages =
            By.tagName("img");

    private By searchBox =

            By.cssSelector(
                    "input[placeholder='Search by name or category...']"
            );

    private By firstProduct =

            By.tagName("h3");


    public void searchProduct(
            String product
    ){

        WebElement search =

                driver.findElement(
                        searchBox
                );

        search.clear();

        search.sendKeys(product);
    }

    public boolean isProductDisplayed(
            String productName
    ) {

        return driver.getPageSource()

                .contains(productName);
    }


    public int getProductCount(){

        return driver.findElements(products)
                .size();
    }


    public List<WebElement> getProductNames(){

        return driver.findElements(productNames);
    }


    public List<WebElement> getProductPrices(){

        return driver.findElements(productPrices);
    }

    public List<WebElement> getProductImages() {

        return driver.findElements(productImages);
    }
    public boolean isProductVisible(
            String productName
    ){

        return driver

                .getPageSource()

                .contains(productName);
    }

    public void openFirstProduct(String s) {

        driver.findElements(

                firstProduct

        ).get(0).click();
    }

    public void openProduct(String productName){

        driver.findElement(
                By.xpath("//h3[text()='" + productName + "']/ancestor::div[1]")
        ).click();
    }
}