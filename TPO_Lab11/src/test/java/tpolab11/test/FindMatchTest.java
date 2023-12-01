package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class FindMatchTest extends CommonConditions {
    private static final String matchId = "7267932720";
    @Test
    public void isTestFound() {
        String url = new MainPage(driver)
                .open()
                .searchMatch(matchId)
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/matches/7267932720", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/matches/7267932720"));
    }
}
