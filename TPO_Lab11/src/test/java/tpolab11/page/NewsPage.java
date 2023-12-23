package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class NewsPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}