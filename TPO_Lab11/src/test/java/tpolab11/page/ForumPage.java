package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/table/tbody/tr[1]/td[1]/a[1]")
    private WebElement newTopicButton;
    public ForumPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TopicPage openTopicPage() {
        newTopicButton.click();
        log.info("Topic page is opened");
        return new TopicPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
