package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DotaBuffTrendsPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/a[2]")
    private WebElement buttonHome;
    public DotaBuffTrendsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String openHome() {
        buttonHome.click();
        return driver.getCurrentUrl();
    }
}
