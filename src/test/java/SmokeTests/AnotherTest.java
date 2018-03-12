package SmokeTests;

import BaseTest.ConfigurationForBrowser;
import Pages.RegistrationPage;
import Utilities.TestLogger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-02-15.
 */
public class AnotherTest extends ConfigurationForBrowser {

    RegistrationPage registrationPage;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception{
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

    }


    @Test(groups = "logging")
    public void testReal() throws Exception{

        driver.get("http://realmadryt.pl");
        TestLogger.log.info("realmadryt ok");


    }
}
