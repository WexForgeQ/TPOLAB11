package tpolab11.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final Logger log = LogManager.getLogger();
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[5]/a")
    private WebElement buttonPlayers;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[3]/a")
    private WebElement buttonHeroes;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/section[1]/article/div/form/input")
    private WebElement inputSearch;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[8]/a")
    private WebElement buttonForum;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/nav/ul/li[7]/a")
    private WebElement buttonBlog;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.navigate().to("https://www.dotabuff.com/");
        log.info("Main page is opened");
        return this;
    }
    public MatchPage searchMatch(String searchText) {
        inputSearch.click();
        inputSearch.sendKeys(searchText + Keys.ENTER);
        log.info("Match was found");
        return new MatchPage(driver);
    }

    public HeroesPage openHeroesPage() {
        buttonHeroes.click();
        log.info("Heroes page is opened");
        return new HeroesPage(driver);
    }

    public PlayersPage openPlayersPage() {
        buttonPlayers.click();
        log.info("Players page is opened");
        return new PlayersPage(driver);
    }

    public BlogPage openBlogPage() {
        buttonBlog.click();
        log.info("Blog page is opened");
        return new BlogPage(driver);
    }

    public ForumPage openForumPage() {
        buttonForum.click();
        log.info("ForumPage is opened");
        return new ForumPage(driver);
    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}