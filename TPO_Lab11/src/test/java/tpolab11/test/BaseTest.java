package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class BaseTest extends CommonConditions {
    @Test
    public void isMainPageOpened() {
        String url = new MainPage(driver)
                .open()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/", url);
        assertThat("Url matched", url.equals("https://www.chess.com/"));
    }
}

