package Pages;

import Commands.DemoType;
import Navigation.NavigationTabDemo;
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


    public MainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Demoqa | Just another WordPress site";
        this.PAGE_URL = "http://demoqa.com";
    }

    public void goToNavTabDemo(DemoType demoType) {

        switch (demoType) {
            case Draggable:
                NavigationTabDemo.DemoDraggable.select();
                break;
            case Tabs:
                NavigationTabDemo.DemoTabs.select();
                break;
        }
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




}
