package Pages;

import Commands.DemoTypeMainPage;
import Navigation.MenuSelector;
import Utilities.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dawidek on 2018-02-13.
 */
public class MainPage extends BaseExtendablePage {

    @FindBy(xpath = "//p/a/img[@src= 'http://demoqa.com/wp-content/uploads/2014/08/pattern-14-300x237.png']") WebElement photo1;
    @FindBy(xpath = "//p/i/a/img[@src= 'http://demoqa.com/wp-content/uploads/2014/08/pattern-14-300x237.png']") WebElement photo2;
    @FindBy(xpath = "//div/i/a/img[@src= 'http://demoqa.com/wp-content/uploads/2014/08/pattern-14-300x237.png']") WebElement photo3;
    @FindBy(xpath = "//a[contains(@href, '#tabs-')]") List<WebElement> tabs;
    @FindBy(xpath = "//b[contains(text(),'Content')]") List<WebElement> descriptions;
    @FindBy(xpath = "//a[@class='dropdown-toggle']") static WebElement menuHeaderButton;
    @FindBy(xpath = "//a[@title='Draggable']") static WebElement draggableListOption;
    @FindBy(xpath = "//a[@title='Tabs']") static WebElement tabsListOption;

    public MainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Demoqa | Just another WordPress site";
        this.PAGE_URL = "http://demoqa.com";
    }

    public void checkPhotos() {
        List<WebElement> photos = new ArrayList<>(Arrays.asList(photo1, photo2, photo3));

        for (WebElement photo : photos) {
            clickOnElement(photo);
            TestLogger.log.info("Photo clicked");
            driver.navigate().back();
        }
    }

    public void checkAllTabs(){
        List<WebElement> elements = tabs;
        Assert.assertEquals(5, elements.size());
        int start = 0;
        int numOfTab = 1;

        for(WebElement tab : elements) {
            clickOnElement(tab);
            WebElement description = descriptions.get(start);
            Assert.assertTrue(description.getText().equalsIgnoreCase("Content " + numOfTab + " Title"));
            TestLogger.log.info("Element " + tab.getText() + " was clicked");
            start++;
            numOfTab++;
        }
    }

    private static class DemoDraggable {
        private static void select() {
            MenuSelector.select(menuHeaderButton, draggableListOption);
        }
    }

    private static class DemoTabs {
        private static void select() {
            MenuSelector.select(menuHeaderButton, tabsListOption);
        }
    }

    public static void goToNavTabDemo(DemoTypeMainPage demoTypeMainPage) {
        switch (demoTypeMainPage) {
            case Draggable:
                DemoDraggable.select();
                break;
            case Tabs:
                DemoTabs.select();
                break;
        }
        TestLogger.log.info(demoTypeMainPage + " selected");
    }

}
