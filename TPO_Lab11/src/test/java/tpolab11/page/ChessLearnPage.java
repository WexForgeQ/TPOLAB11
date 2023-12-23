package tpolab11.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChessLearnPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div/a[7]")
    private WebElement buttonOpening;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/a[1]")
    private WebElement buttonLessons;

    public ChessLearnPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public ChessOpeningSearchPage openOpenings() {
        buttonOpening.click();
        log.info("Openings page is opened");
        return new ChessOpeningSearchPage(driver);
    }
    public LessonsPage openLessons() throws InterruptedException {
        Thread.sleep(1000);
        buttonLessons.click();
        log.info("Lessons page is opened");
        return new LessonsPage(driver);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
