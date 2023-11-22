package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DotaBuffCountersPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/nav/ul/li[5]/ul/li[3]/a")
    private WebElement buttonAbaddonAbilities;
    public DotaBuffCountersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String openAbaddonAbilities() {
        buttonAbaddonAbilities.click();
        return driver.getCurrentUrl();
    }
}
