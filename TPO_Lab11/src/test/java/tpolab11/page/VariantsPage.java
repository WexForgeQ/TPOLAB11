package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class VariantsPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    public VariantsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}