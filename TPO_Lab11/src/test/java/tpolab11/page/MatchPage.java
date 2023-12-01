package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MatchPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(className = "team-results")
    private WebElement teamResults;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/div/h1")
    private WebElement currentMatchId;
    @FindBy(className = "match-result")
    private WebElement winnerSide;
    @FindBy(className = "header-content-secondary")
    private WebElement matchSecondary;
    public MatchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean checkMatchDetails(String matchId) {
        log.info("Match details checked");
        return  teamResults.isDisplayed() &&
                currentMatchId.getText().replaceAll("\\s+", "").equals("Match" + matchId + "Overview") &&
                winnerSide.isDisplayed() &&
                matchSecondary.isDisplayed();
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
