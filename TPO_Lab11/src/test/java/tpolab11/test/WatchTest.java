package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class WatchTest extends CommonConditions {
    @Test
    public void TestisFound() {
        String url = new MainPage(driver)
                .open()
                .openWatch()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/watch", url);
        assertThat("Url matched", url.equals("https://www.chess.com/watch"));
    }
}
