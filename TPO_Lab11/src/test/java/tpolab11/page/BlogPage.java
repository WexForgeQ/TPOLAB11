package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/div[1]/nav/span[2]/a")
    private WebElement buttonNext;
    public BlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String nextPage() {
        buttonNext.click();
        log.info("Next page of blog is open");
        return getUrl();
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
