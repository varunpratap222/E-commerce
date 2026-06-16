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

            By.xpath("//input");

    private By mobileFilter =

            By.xpath("//button[text()='Mobile']");

    public void selectMobileFilter() {

        driver.findElement(

                mobileFilter

        ).click();
    }

    public void searchProduct(String product) {

        WebElement search =

                driver.findElement(searchBox);

        search.clear();

        search.sendKeys(product);
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


    public void clickFirstProduct(){

        driver.findElements(products)
                .get(0)
                .click();
    }
}