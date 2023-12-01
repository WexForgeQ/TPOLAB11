package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class BackHomeTest extends CommonConditions {
    @Test
    public void isMainPageBackOpened() {
        String url = new MainPage(driver)
                .open()
                .openHeroesPage()
                .openAbaddon()
                .openHome()
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/"));
    }
}
