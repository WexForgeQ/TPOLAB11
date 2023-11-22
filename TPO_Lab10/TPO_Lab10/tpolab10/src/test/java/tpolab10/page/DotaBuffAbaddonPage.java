package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DotaBuffAbaddonPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[3]/a")
    private WebElement buttonAbaddonItems;

    public DotaBuffAbaddonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openAbaddonItems() {
        buttonAbaddonItems.click();
        return driver.getCurrentUrl();
    }
}