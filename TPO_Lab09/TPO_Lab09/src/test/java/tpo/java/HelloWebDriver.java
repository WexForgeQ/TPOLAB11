package tpo.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        WebElement searchButton = driver.findElement(By.cssSelector("#docsearch > button"));
        searchButton.click();
        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.quit();

    }
}
