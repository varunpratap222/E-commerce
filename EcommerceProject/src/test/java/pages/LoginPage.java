package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    private By email =
            By.name("email");

    private By password =
            By.name("password");

    private By loginBtn =
            By.tagName("button");

    private By errorMessage =
            By.xpath("//p[text()='Invalid credentials']");

    public void enterEmail(String value) {

        driver.findElement(email)
                .sendKeys(value);
    }

    public void enterPassword(String value) {

        driver.findElement(password)
                .sendKeys(value);
    }

    public void clickLogin() {

        driver.findElement(loginBtn)
                .click();
    }

    public void login(
            String email,
            String password
    ) {

        enterEmail(email);

        enterPassword(password);

        clickLogin();
    }

    public String getErrorDisplayed() {
        return driver.findElement(errorMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}