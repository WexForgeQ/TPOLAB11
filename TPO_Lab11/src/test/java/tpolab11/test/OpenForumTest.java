package tpolab11.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class OpenForumTest extends CommonConditions {
    @Test
    public void isTestFound() {
        String url = new MainPage(driver)
                .open()
                .openForumPage()
                .getUrl();
        Assert.assertEquals("https://www.dotabuff.com/forums/general", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/forums/general"));
    }
}
