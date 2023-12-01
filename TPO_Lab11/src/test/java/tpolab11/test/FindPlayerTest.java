package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class FindPlayerTest extends CommonConditions {
    @Test
    public void isPlayerFound() {
        String url = new MainPage(driver)
                .open()
                .openPlayersPage()
                .openYatoro();
        Assert.assertEquals("https://www.dotabuff.com/players/321580662", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/players/321580662"));
    }
}
