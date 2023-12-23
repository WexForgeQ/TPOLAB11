package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[8]/div[3]/a[2]")
    private WebElement buttonPlay;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[8]/div[3]/a[3]")
    private WebElement buttonPuzzles;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[8]/div[3]/a[4]")
    private WebElement buttonLearn;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[8]/div[3]/a[5]")
    private WebElement buttonWatch;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[8]/div[3]/a[6]")
    private WebElement buttonNews;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to("https://www.chess.com");
        log.info("Main page is opened");
        return this;
    }
    public PlayPage openPlay() {
        buttonPlay.click();
        log.info("Play page is opened");
        return new PlayPage(driver);
    }

    public ChessLearnPage openLearn() {
        buttonLearn.click();
        log.info("Learn page is opened");
        return new ChessLearnPage(driver);
    }

    public PuzzlesPage openPuzzles() {
        buttonPuzzles.click();
        log.info("Puzzles Page is opened");
        return new PuzzlesPage(driver);
    }

    public WatchPage openWatch() {
        buttonWatch.click();
        log.info("Watch page is opened");
        return new WatchPage(driver);
    }

    public ChessNewsPage openNews() {
        buttonNews.click();
        log.info("News is opened");
        return new ChessNewsPage(driver);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}