package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutBtn =
            By.xpath("//button[contains(text(),'Logout')]");

    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}