package tpolab11.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckMatchDetailsTest extends CommonConditions {
    private static final String matchId = "7267932720";
    @Test
    public void isTestFound() {
        Boolean isMatchInfo = new MainPage(driver)
                .open()
                .searchMatch(matchId)
                .checkMatchDetails(matchId);
        Assert.assertTrue(isMatchInfo);
        assertThat("Test is found", isMatchInfo.equals(true));
    }
}
