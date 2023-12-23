package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PlayPage extends BasePage{
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[1]/div[8]/div[3]/a[1]")
    private WebElement buttonHome;
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[1]/a[2]")
    private WebElement buttonComputer;
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[1]/a[5]")
    private WebElement buttonVariants;
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div[1]/a[1]")
    private WebElement buttonOnline;
    public PlayPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage openHome() {
        buttonHome.click();
        log.info("Home page is opened");
        return new MainPage(driver);
    }
    public ComputerPlay PlayComputer() {
        buttonComputer.click();
        log.info("Computer play page is opened");
        return new ComputerPlay(driver);
    }
    public VariantsPage PlayVariants() {
        buttonVariants.click();
        log.info("Variants play page is opened");
        return new VariantsPage(driver);
    }
    public OnlinePage PlayOnline() {
        buttonOnline.click();
        log.info("Online play page is opened");
        return new OnlinePage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
