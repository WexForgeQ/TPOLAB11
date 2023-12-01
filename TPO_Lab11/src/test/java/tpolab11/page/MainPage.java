package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final Logger log = LogManager.getLogger();

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[3]/a")
    private WebElement buttonHeroes;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to("https://www.dotabuff.com/");
        log.info("Main page is opened");
        return this;
    }

    public HeroesPage openHeroesPage() {
        buttonHeroes.click();
        log.info("Heroes page is opened");
        return new HeroesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}