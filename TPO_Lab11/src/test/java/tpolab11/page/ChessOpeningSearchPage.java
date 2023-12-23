package tpolab11.page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChessOpeningSearchPage extends BasePage{
    private WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/div[1]/div[4]/div[1]/div/div/div[1]/input")
    private WebElement searchField;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div/div[2]/div/div[2]/div/button")
    private WebElement okButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/div[1]/div[4]/div[1]/div[2]/div[2]/a")
    private WebElement openingButton;
    @FindBy(xpath = "/html/body/div[19]/button/span")
    private WebElement closeButton;

    public ChessOpeningSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public OpeningPage searchOpening(String openingName) throws InterruptedException {
        okButton.click();
        searchField.click();
        searchField.sendKeys(openingName + Keys.ENTER);
        Thread.sleep(100);
        closeButton.click();
        openingButton.click();
        return new OpeningPage(driver);
    }
    public String getUrl() throws InterruptedException {
        Thread.sleep(100);
        return driver.getCurrentUrl();
    }
}
