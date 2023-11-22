package tpolab10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDotabuffFindHero {
    @Test
    public void HeroInformation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dotabuff.com/");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.dotabuff.com/", currentUrl);
        Thread.sleep(500);

        WebElement buttonHeroes = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[3]/a"));
        buttonHeroes.click();
        WebElement heroesPageTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Heroes')]"));
        Assert.assertTrue(heroesPageTitle.isDisplayed());
        Thread.sleep(500);

        WebElement buttonAbaddon = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[4]/section[2]/footer/div/a[1]"));
        buttonAbaddon.click();
        WebElement abaddonPageTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Abaddon')]"));
        Assert.assertTrue(abaddonPageTitle.isDisplayed());
        Thread.sleep(500);

        WebElement buttonItems = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[3]/a"));
        buttonItems.click();
        String expectedTitle = "Abaddon - Items - DOTABUFF - Dota 2 Stats";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(500);

        WebElement buttonCounters = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[4]/a"));
        buttonCounters.click();
        expectedTitle = "Abaddon - Counters - DOTABUFF - Dota 2 Stats";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(500);

        WebElement buttonAbilityBuilds = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[5]/ul/li[3]/a"));
        buttonAbilityBuilds.click();
        expectedTitle = "Abaddon - Abilities - DOTABUFF - Dota 2 Stats";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(500);

        WebElement buttonTrends = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[5]/ul/li[5]/a"));
        buttonTrends.click();
        expectedTitle = "Abaddon - Trends - DOTABUFF - Dota 2 Stats";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(500);

        WebElement buttonDotabuff = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a[2]"));
        buttonDotabuff.click();
        String expectedUrl = "https://www.dotabuff.com/";
        String redirectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, redirectedUrl);
        Thread.sleep(500);

        driver.quit();
    }
}
