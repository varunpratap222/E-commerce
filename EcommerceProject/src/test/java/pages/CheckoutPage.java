package pages;

import org.openqa.selenium.Alert;
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

    private By fullName =

            By.name("fullName");

    private By phone =

            By.name("phone");

    private By city =

            By.name("city");

    private By state =

            By.name("state");

    private By pincode =

            By.name("pincode");

    private By address =

            By.name("address");

    private By cod =

            By.cssSelector(
                    "input[value='COD']"
            );

    private By upi =

            By.cssSelector(
                    "input[value='UPI']"
            );

    private By card =

            By.cssSelector(
                    "input[value='CARD']"
            );

    private By placeOrder =

            By.xpath(
                    "//button[contains(text(),'Place Order')]"
            );



    public void enterFullName(String name){

        driver.findElement(fullName)

                .sendKeys(name);
    }

    public void enterCity(String value){

        driver.findElement(city)

                .sendKeys(value);
    }


    public void enterState(String value){

        driver.findElement(state)

                .sendKeys(value);
    }


    public void enterPincode(String value){

        driver.findElement(pincode)

                .sendKeys(value);
    }




    public void selectCOD(){

        driver.findElement(cod)

                .click();
    }


    public void selectUPI(){

        driver.findElement(upi)

                .click();
    }


    public void selectCard(){

        driver.findElement(card)

                .click();
    }




    public boolean isCODSelected(){

        return driver.findElement(cod)

                .isSelected();
    }


    public boolean isUPISelected(){

        return driver.findElement(upi)

                .isSelected();
    }


    public boolean isCardSelected(){

        return driver.findElement(card)

                .isSelected();
    }

    public void clearName(){

        driver.findElement(nameField)
                .clear();
    }

    public void clearAddress(){

        driver.findElement(addressField)
                .clear();
    }

    public void clearPhone(){

        driver.findElement(phoneField)
                .clear();
    }




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

    public String getAlertText(){

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


    public void acceptAlert(){

        driver.switchTo()

                .alert()

                .accept();
    }
}