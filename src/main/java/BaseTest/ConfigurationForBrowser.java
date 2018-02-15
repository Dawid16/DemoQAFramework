package BaseTest;

import Utilities.DriverFactory;
import Utilities.TestLogger;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static Utilities.DriverFactory.getDriver;

/**
 * Created by Dawidek on 2018-02-13.
 */
public class ConfigurationForBrowser {

    public WebDriver driver;
    public WebDriverWait _wait;
    final int BASE_TIMEOUTS_SECONDS = 5;


    @BeforeClass(alwaysRun = true)
    public void browserSetup() throws Exception{

        this.driver = getDriver(DriverFactory.getBrowserTypeByProperty());
        driver.manage().timeouts().implicitlyWait(BASE_TIMEOUTS_SECONDS, TimeUnit.SECONDS);
        _wait = new WebDriverWait(driver, BASE_TIMEOUTS_SECONDS);
        TestLogger.log.setLevel(Level.ALL);
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        TestLogger.log.info("AfterClass is executing ...");
        this.driver.close();
    }



}
