package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PuzzlesPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[3]/div/section/div/div[3]/div[1]/button")
    private WebElement hintButton;
    @FindBy(xpath = "/html/body/div[37]/div/div[2]/div/div[2]/div/button")
    private WebElement okButton;
    public PuzzlesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Boolean HintTest() throws InterruptedException {
        Thread.sleep(1000);
        okButton.click();
        hintButton.click();
        log.info("Hint accepted");
        return true;
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}