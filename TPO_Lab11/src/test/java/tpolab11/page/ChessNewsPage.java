package tpolab11.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChessNewsPage extends BasePage{
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/div[1]/div[3]/a")
        private WebElement buttonNews;

    public ChessNewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public NewsPage openNews() {
        log.info("News concrete page is opened");
        buttonNews.click();
        return new NewsPage(driver);
    }
}
