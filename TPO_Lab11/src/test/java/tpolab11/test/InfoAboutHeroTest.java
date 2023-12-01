package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.HeroesPage;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class InfoAboutHeroTest extends CommonConditions {
    @Test
    public void CheckInfoAboutHeroes() {
        String url = new MainPage(driver)
                .open()
                .openHeroesPage()
                .openAbaddon()
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/heroes/abaddon", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/heroes/abaddon"));
    }
}
