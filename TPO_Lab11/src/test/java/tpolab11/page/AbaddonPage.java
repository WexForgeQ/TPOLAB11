package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AbaddonPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/a[2]")
    private WebElement buttonHome;
    public AbaddonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public MainPage openHome() {
        buttonHome.click();
        log.info("Home page is opened");
        return new MainPage(driver);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
