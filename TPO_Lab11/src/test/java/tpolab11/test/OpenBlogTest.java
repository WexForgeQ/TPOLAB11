package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class OpenBlogTest extends CommonConditions {
    @Test
    public void isLessonsOpen() throws InterruptedException {
        String url = new MainPage(driver)
                .open()
                .openLearn()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/learn", url);
        assertThat("Url matched", url.equals("https://www.chess.com/learn"));
    }
}
