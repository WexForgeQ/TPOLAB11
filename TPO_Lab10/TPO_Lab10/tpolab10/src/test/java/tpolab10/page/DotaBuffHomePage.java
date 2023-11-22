package tpolab10.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DotaBuffHomePage {
    private static final String HOMEPAGE_URL = "https://www.dotabuff.com/";
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[3]/a")
    private WebElement buttonHeroes;

    public DotaBuffHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String openHeroes() {
        buttonHeroes.click();
        return driver.getCurrentUrl();
    }
    public DotaBuffHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
}
