package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.name("name");
    private By email = By.name("email");
    private By password = By.name("password");
    private By registerBtn = By.xpath("//button[@type='submit']");

    public void enterName(String value) {
        driver.findElement(name).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    public void register(String name,
                         String email,
                         String password) {

        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegister();
    }
}