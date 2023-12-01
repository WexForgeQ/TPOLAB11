package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroesPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/section[2]/footer/div/a[1]")
    private WebElement buttonAbaddon;
    public HeroesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public AbaddonPage openAbaddon() {
        buttonAbaddon.click();
        log.info("Abaddon page is opened");
        return new AbaddonPage(driver);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
