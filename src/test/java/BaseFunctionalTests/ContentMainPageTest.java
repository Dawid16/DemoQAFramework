package BaseFunctionalTests;

import BaseTest.ConfigurationForBrowser;
import Commands.DemoTypeMainPage;
import Pages.MainPage;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class ContentMainPageTest extends ConfigurationForBrowser {

    @Test(groups = "logging")
    public void contentMainPageCheck() throws Exception{

        MainPage mainPage = new MainPage(driver);

        mainPage.loadPage();
        MainPage.goToNavTabDemo(DemoTypeMainPage.Tabs);
        //mainPage.checkPhotos();
        //mainPage.checkAllTabs();
    }
}
