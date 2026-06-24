package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){

        this.driver = driver;
    }

    private By removeButton =

            By.xpath("//button[text()='Remove']");

    private By subtotal =
            By.xpath("//p[contains(text(),'Subtotal')]");

    private By cartItems =

            By.xpath("//h3");

    private By totalAmount =

            By.xpath("//h2[contains(text(),'Total Amount')]");

    private By checkoutButton =

            By.xpath("//button[contains(text(),'Proceed to Checkout')]");

    public void clickCheckout(){

        driver.findElement(

                checkoutButton

        ).click();
    }

    private By increaseButton =

            By.xpath("(//button[text()='+'])[1]");

    private By decreaseButton =

            By.xpath("(//button[text()='-'])[1]");

    public int getQuantity(String productName){

        String xpath =
                "//h3[text()='"+productName+"']" +
                        "/following::div[contains(@style,'gap: 15px')][1]/span";

        return Integer.parseInt(
                driver.findElement(
                        By.xpath(xpath)
                ).getText()
        );
    }
    public void increaseQuantity(String productName){

        int oldValue = getQuantity(productName);

        String xpath =

                "//h3[text()='"+productName+"']"

                        + "/following::button[text()='+'][1]";

        driver.findElement(

                By.xpath(xpath)

        ).click();


        WebDriverWait wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(5)

                );


        wait.until(driver ->

                getQuantity(productName)

                        == oldValue + 1

        );
    }
    public void decreaseQuantity(String productName){

        int oldValue = getQuantity(productName);

        String xpath =

                "//h3[text()='"+productName+"']"

                        + "/following::button[text()='-'][1]";

        driver.findElement(

                By.xpath(xpath)

        ).click();


        WebDriverWait wait =

                new WebDriverWait(

                        driver,

                        Duration.ofSeconds(5)

                );


        wait.until(driver ->

                getQuantity(productName)

                        == oldValue - 1

        );
    }

    public boolean isCartVisible(){

        return driver.findElements(

                cartItems

        ).size() > 0;
    }

    public boolean isTotalVisible(){

        return driver.findElement(

                totalAmount

        ).isDisplayed();
    }

    public boolean isCheckoutVisible(){

        return driver.findElement(

                checkoutButton

        ).isDisplayed();
    }
    private By productNames =

            By.xpath("//h3");



    public void proceedToCheckout(){

        driver.findElement(
                checkoutButton
        ).click();
    }

    public boolean isProductPresent(String productName){

        List<WebElement> products = driver.findElements(productNames);

        System.out.println("Searching for: [" + productName + "]");

        for(WebElement product : products){

            System.out.println("Found: [" + product.getText() + "]");

            if(product.getText().trim()
                    .equalsIgnoreCase(productName.trim())){

                return true;
            }
        }

        return false;
    }
    public int getCartSize(){

        List<WebElement> items =

                driver.findElements(

                        cartItems

                );

        return items.size();
    }
    public int getTotalAmount() {

        String amount = driver.findElement(totalAmount)
                .getText()
                .replace("Total Amount: ₹","")
                .trim();

        return Integer.parseInt(amount);
    }
    public int getProductPrice(String productName){

        String xpath =

                "//h3[text()='"+productName+"']" +
                        "/following-sibling::p[1]";

        String price =

                driver.findElement(

                                By.xpath(xpath)

                        )

                        .getText()

                        .replace("₹","")
                        .trim();

        return Integer.parseInt(price);
    }
    public int getSubtotal(String productName){

        String xpath =

                "//h3[text()='"+productName+"']" +
                        "/following::p[contains(text(),'Subtotal')][1]";

        String subtotal =

                driver.findElement(

                                By.xpath(xpath)

                        )

                        .getText()

                        .replace("Subtotal: ₹","")
                        .trim();

        return Integer.parseInt(subtotal);
    }
    public void removeProduct(String productName){

        String xpath =
                "//h3[text()='" + productName + "']" +
                        "/following::button[text()='Remove'][1]";

        driver.findElement(By.xpath(xpath)).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        emptyCartMessage
                )
        );
    }

    private By emptyCartMessage =
            By.xpath("//h2[contains(text(),'Your Cart is Empty')]");

    public boolean isCartEmpty() {

        return driver.findElements(emptyCartMessage)
                .size() > 0;
    }
    public void removeAllProducts() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        By removeBtn = By.xpath("//button[text()='Remove']");

        while (driver.findElements(removeBtn).size() > 0) {

            WebElement button =
                    wait.until(ExpectedConditions.elementToBeClickable(removeBtn));

            button.click();

            wait.until(ExpectedConditions.stalenessOf(button));
        }
    }

}