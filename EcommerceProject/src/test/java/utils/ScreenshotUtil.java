package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void capture(
            WebDriver driver,
            String fileName
    ) {

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        try {

            FileUtils.copyFile(
                    src,
                    new File(
                            "screenshots/"
                                    + fileName
                                    + ".png"
                    )
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}