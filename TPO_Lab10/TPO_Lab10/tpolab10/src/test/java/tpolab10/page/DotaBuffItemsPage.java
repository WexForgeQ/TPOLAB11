package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DotaBuffItemsPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[4]/a")
    private WebElement buttonAbaddonCounters;

    public DotaBuffItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openAbaddonCounters() {
        buttonAbaddonCounters.click();
        return driver.getCurrentUrl();
    }
}
