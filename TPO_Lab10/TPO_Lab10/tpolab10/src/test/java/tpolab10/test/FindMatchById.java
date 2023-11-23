package tpolab10.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tpolab10.page.*;
public class FindMatchById {
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
    public void FindMatchById() throws InterruptedException {
        String currentUrl = "";
        String correctMatchId = "7267932720";
        String incorrectMatchId = " ";
        String correctMatchUrl = "https://www.dotabuff.com/matches/" + correctMatchId;
        Boolean isMatchInfo;

        currentUrl = new DotaBuffHomePage(driver).openPage().searchMatch(correctMatchId);
        Assert.assertEquals(correctMatchUrl, currentUrl);

        isMatchInfo = new MatchPage(driver).checkMatchDetails(correctMatchId);
        Assert.assertTrue(isMatchInfo);

        currentUrl = new DotaBuffHomePage(driver).openPage().searchMatch(incorrectMatchId);
        Assert.assertNotEquals(correctMatchUrl, currentUrl);
    }
}
