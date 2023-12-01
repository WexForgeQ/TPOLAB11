package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class OpenBlogTest extends CommonConditions {
    @Test
    public void isBlogOpen() {
        String url = new MainPage(driver)
                .open()
                .openBlogPage()
                .nextPage();
        Assert.assertEquals("https://www.dotabuff.com/blog?page=2", url);
        assertThat("Url matched", url.equals("https://www.dotabuff.com/blog?page=2"));
    }
}
