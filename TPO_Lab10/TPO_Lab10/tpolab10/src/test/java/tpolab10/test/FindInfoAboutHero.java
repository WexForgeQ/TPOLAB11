package tpolab10.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tpolab10.page.*;

public class FindInfoAboutHero {
    private WebDriver driver;
    @Before
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    public void FindInfoAboutHero() throws InterruptedException {
        String currentUrl = "";
        String heroesUrl = "https://www.dotabuff.com/heroes";
        String abaddonUrl = "https://www.dotabuff.com/heroes/abaddon";
        String abaddonItemsUrl = "https://www.dotabuff.com/heroes/abaddon/items";
        String abaddonCountersUrl = "https://www.dotabuff.com/heroes/abaddon/counters";
        String abaddonAbilitiesUrl = "https://www.dotabuff.com/heroes/abaddon/abilities";
        String abaddonTrendsUrl = "https://www.dotabuff.com/heroes/abaddon/trends";
        String homeUrl = "https://www.dotabuff.com/";

        currentUrl = new DotaBuffHomePage(driver).openPage().openHeroes();
        Assert.assertEquals(heroesUrl, currentUrl);

        currentUrl = new DotaBuffHeroesPage(driver).openAbaddon();
        Assert.assertEquals(abaddonUrl, currentUrl);

        currentUrl = new DotaBuffAbaddonPage(driver).openAbaddonItems();
        Assert.assertEquals(abaddonItemsUrl, currentUrl);

        currentUrl = new DotaBuffItemsPage(driver).openAbaddonCounters();
        Assert.assertEquals(abaddonCountersUrl, currentUrl);

        currentUrl = new DotaBuffCountersPage(driver).openAbaddonAbilities();
        Assert.assertEquals(abaddonAbilitiesUrl, currentUrl);

        currentUrl = new DotaBuffAbilitiesPage(driver).openAbaddonTrends();
        Assert.assertEquals(abaddonTrendsUrl, currentUrl);

        currentUrl = new DotaBuffTrendsPage(driver).openHome();
        Assert.assertEquals(homeUrl, currentUrl);
    }
}