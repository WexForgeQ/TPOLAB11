package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class OpenTopicTest extends CommonConditions {
    @Test
    public void isTestFound() {
        String url = new MainPage(driver)
                .open()
                .openForumPage()
                .openTopicPage()
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/topics/2015-10-20-predict-my-mmr-megathread", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/topics/2015-10-20-predict-my-mmr-megathread"));
    }
}
