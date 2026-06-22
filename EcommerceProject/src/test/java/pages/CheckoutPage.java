package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;
    }

    private By nameField =
            By.xpath("//input[@name='fullName']");

    private By addressField =
            By.name("address");

    private By phoneField =
            By.name("phone");

    private By placeOrderButton =
            By.xpath("//button[contains(text(),'Place Order')]");




    public boolean isCheckoutPageOpened(){

        return driver.findElement(
                placeOrderButton
        ).isDisplayed();
    }


    public void enterName(String name){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(nameField)
        );

        field.clear();
        field.sendKeys(name);
    }



    public void enterAddress(String address){

        driver.findElement(
                addressField
        ).sendKeys(address);
    }


    public void enterPhone(String phone){

        driver.findElement(
                phoneField
        ).sendKeys(phone);
    }

    public void selectPaymentMethod(String method){

        driver.findElement(
                By.xpath("//input[@value='" + method + "']")
        ).click();
    }


    public void clickPlaceOrder(){

        driver.findElement(
                placeOrderButton
        ).click();
    }
    public void fillCheckoutForm(
            String name,
            String phone,
            String city,
            String state,
            String pincode,
            String address
    ){
        driver.findElement(By.name("fullName")).sendKeys(name);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("pincode")).sendKeys(pincode);
        driver.findElement(By.name("address")).sendKeys(address);
    }
}