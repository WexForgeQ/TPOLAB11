package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class HeroesTest extends CommonConditions {
    @Test
    public void isHeroesPageOpened() {
        String url = new MainPage(driver)
                .open()
                .openHeroesPage()
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/heroes", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/heroes"));
    }
}

