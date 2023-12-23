package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class ComputerPlayTest extends CommonConditions {
    @Test
    public void isTestFound() {
        String url = new MainPage(driver)
                .open()
                .openPlay()
                .PlayComputer()
                .getUrl();
        Assert.assertEquals("https://www.chess.com/play/computer", url);
        assertThat("Url matched", url.equals("https://www.chess.com/play/computer"));
    }
}
