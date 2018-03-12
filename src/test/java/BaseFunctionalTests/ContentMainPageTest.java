package BaseFunctionalTests;

import BaseTest.ConfigurationForBrowser;
import Commands.DemoType;
import Pages.DraggablePage;
import Pages.MainPage;
import Pages.RegistrationPage;
import Utilities.TestLogger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class ContentMainPageTest extends ConfigurationForBrowser {

    MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception{
        mainPage = PageFactory.initElements(driver, MainPage.class);

    }


    @Test(groups = "logging")
    public void contentMainPageCheck() throws Exception{

        driver.manage().deleteAllCookies();
        mainPage.loadPage();
        //mainPage.goToNavTabDemo(DemoType.Tabs);
        mainPage.checkPhotos();
        mainPage.checkAllTabs();
    }
}
