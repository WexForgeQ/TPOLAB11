package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PlayersPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/section/article/table/tbody/tr[1]/td[2]/a[1]")
    WebElement YatoroButton;
    public PlayersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String openYatoro() {
        YatoroButton.click();
        log.info("Player is selected");
        return getUrl();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
