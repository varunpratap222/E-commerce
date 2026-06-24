package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver){

        this.driver = driver;
    }

    private By pageTitle =

            By.xpath("//h1[text()='My Orders']");

    private By orders =

            By.xpath("//h2[contains(text(),'Order #')]");

    private By statuses =

            By.xpath("//*[text()='CONFIRMED']");

    private By productNames =

            By.xpath("//h3");

    private By totals =

            By.xpath("//h2[contains(text(),'Total:')]");

    private By backButton =

            By.xpath("//button[contains(text(),'Back To Products')]");


    public boolean isPageVisible(){

        return driver.findElement(

                pageTitle

        ).isDisplayed();
    }


    public int getOrderCount(){

        return driver.findElements(

                orders

        ).size();
    }


    public boolean isStatusDisplayed(){

        return driver.findElements(

                statuses

        ).size() > 0;
    }


    public boolean isProductPresent(

            String product

    ){

        return driver

                .getPageSource()

                .contains(product);
    }


    public boolean isTotalVisible(){

        return driver.findElements(

                totals

        ).size() > 0;
    }


    public void clickBack(){

        driver.findElement(

                backButton

        ).click();
    }


    public int getProductCount(){

        return driver.findElements(

                productNames

        ).size();
    }
}