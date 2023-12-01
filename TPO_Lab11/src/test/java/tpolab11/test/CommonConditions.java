package tpolab11.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tpolab11.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tpolab11.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected final Logger log = LogManager.getLogger();
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }
    @AfterMethod()
    public void stopBrowser() {
        DriverSingleton.closeDriver();
        log.info("Test completed");
    }
}
