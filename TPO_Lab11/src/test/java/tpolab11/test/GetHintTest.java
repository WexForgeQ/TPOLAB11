package tpolab11.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
public class GetHintTest extends CommonConditions {
    @Test
    public void isTestFound() throws InterruptedException {
        Boolean test = new MainPage(driver)
                .open()
                .openPuzzles()
                .HintTest();
        Assert.assertEquals(test, true);
        assertThat("Test is found", test.equals(true));
    }
}
