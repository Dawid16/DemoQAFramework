package BaseFunctionalTests;

import BaseTest.ConfigurationForBrowser;
import Pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class ContentMainPageTest extends ConfigurationForBrowser {

    @Test(groups = "logging")
    public void contentMainPageCheck() throws Exception{

        MainPage mainPage = new MainPage(driver);

        mainPage.loadPage();
        //mainPage.goToNavTabDemo(DemoType.Tabs);
        mainPage.checkPhotos();
        mainPage.checkAllTabs();
    }
}
