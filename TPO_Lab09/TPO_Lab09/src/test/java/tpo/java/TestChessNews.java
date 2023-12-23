package tpo.java;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestDotabuffFindHero {
    @Test
    public void HeroInformation() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.chess.com/");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.chess.com/", currentUrl);

        WebElement buttonChessToday = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[8]/div[3]/a[6]"));
        buttonChessToday.click();
        WebElement buttonNews = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[1]/div[3]/a"));
        Assert.assertTrue(buttonNews.isDisplayed());
        buttonNews.click();
        WebElement buttonSomeNews = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[1]/div[2]/div/div/div[1]/article[1]/h2/a"));
        buttonSomeNews.click();
        WebElement postImage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div[1]/div[2]/div/article/div[1]/img"));
        Assert.assertTrue(postImage.isDisplayed());
        
        driver.quit();
    }
}
