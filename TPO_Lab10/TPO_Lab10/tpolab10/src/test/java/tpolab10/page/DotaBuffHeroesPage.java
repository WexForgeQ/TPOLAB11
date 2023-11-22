package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DotaBuffHeroesPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/section[2]/footer/div/a[1]")
    private WebElement buttonAbaddon;

    public DotaBuffHeroesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String openAbaddon() {
        buttonAbaddon.click();
        return driver.getCurrentUrl();
    }
}
