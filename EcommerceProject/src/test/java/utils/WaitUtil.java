package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    public static WebDriverWait getWait(
            WebDriver driver
    ) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }
}