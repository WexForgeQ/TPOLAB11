package tpolab11.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import tpolab11.page.MainPage;

public class CheckMatchDetails extends CommonConditions {
    private static final String matchId = "7267932720";
    @Test
    public void isTestFound() {
        Boolean isMatchInfo = new MainPage(driver)
                .open()
                .searchMatch(matchId)
                .checkMatchDetails(matchId);
        Assert.assertTrue(isMatchInfo);
    }
}
