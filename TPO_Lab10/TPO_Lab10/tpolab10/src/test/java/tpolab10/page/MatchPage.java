package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class MatchPage {
    private WebDriver driver;
    @FindBy(className = "team-results")
    private WebElement teamResults;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/div/h1")
    private WebElement currentMatchId;
    @FindBy(className = "match-result")
    private WebElement winnerSide;
    @FindBy(className = "header-content-secondary")
    private WebElement matchSecondary;

    public MatchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkMatchDetails(String matchId) {
        return  teamResults.isDisplayed() &&
                currentMatchId.getText().replaceAll("\\s+", "").equals("Match" + matchId + "Overview") &&
                winnerSide.isDisplayed() &&
                matchSecondary.isDisplayed();
    }
}
