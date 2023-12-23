package tpolab10.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import tpolab10.page.*;

public class LearnOpeningsTest {
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
        String homeUrl = "https://www.chess.com/";
        String learnUrl = "https://www.chess.com/learn";
        String openingsUrl = "https://www.chess.com/openings";
        String foundOpeningUrl = "https://www.chess.com/openings/French-Defense";

        currentUrl = new ChessHomePage(driver).openPage().openLearn();
        Assert.assertEquals(learnUrl, currentUrl);
        currentUrl = new ChessLearnPage(driver).openOpenings();
        Assert.assertEquals(openingsUrl, currentUrl);
        currentUrl = new ChessOpeningSearchPage(driver).searchOpening("French Defense");
        Assert.assertEquals(foundOpeningUrl, currentUrl);


    }
}