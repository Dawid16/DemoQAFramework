package BaseFunctionalTests;

import BaseTest.ConfigurationForBrowser;
import Commands.DemoTypeMainPage;
import Pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class ContentHomePageTest extends ConfigurationForBrowser {

    @Test(groups = "logging")
    public void contentMainPageCheck() throws Exception{

        HomePage homePage = new HomePage(driver);

        homePage.loadPage();
        HomePage.goToNavTabDemo(DemoTypeMainPage.Tabs);
        //mainPage.checkPhotos();
        //mainPage.checkAllTabs();
    }
}
