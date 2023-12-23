package tpolab10.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import tpolab10.page.*;

public class TestNewsPage {
    private WebDriver driver;
    @Before
    public void browserSetup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    public void GetNews() throws InterruptedException {
        String currentUrl = "";
        String homeUrl = "https://chess.com/";
        String chessTodayUrl = "https://www.chess.com/today";
        String newsUrl = "https://www.chess.com/news";
        String

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