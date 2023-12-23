package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class VariantPlayTest extends CommonConditions {
    @Test
    public void isTestFound() {
        String url = new MainPage(driver)
                .open()
                .openPlay()
                .PlayVariants()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/variants", url);
        assertThat("Url matched", url.equals("https://www.chess.com/variants"));
    }
}
