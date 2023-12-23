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
                .openPlay()
                .openHome()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/", url);
        assertThat("Url matched", url.equals("https://www.chess.com/"));
    }
}
