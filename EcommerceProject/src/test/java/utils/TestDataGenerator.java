package utils;

public class TestDataGenerator {

    public static String getUniqueEmail() {

        return "user"
                + System.currentTimeMillis()
                + "@gmail.com";
    }
}