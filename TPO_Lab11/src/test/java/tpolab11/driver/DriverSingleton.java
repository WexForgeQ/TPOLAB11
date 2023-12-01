package tpolab11.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverSingleton {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            Map<String, Object> options = new HashMap<>();
            options.put("enableVNC", true);
            options.put("enableVideo", true);

            webDriver.set(new ChromeDriver());
            webDriver.get().manage().window().maximize();
        }
        return webDriver.get();
    }

    public static void closeDriver() {
        webDriver.get().quit();
        webDriver.set(null);
    }
}