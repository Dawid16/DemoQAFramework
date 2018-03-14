package Pages;

import Utilities.TestLogger;
import Utilities.Waits;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

/**
 * Created by Dawidek on 2018-02-04.
 */
public class BaseExtendablePage {

    public static WebDriver driver;
    public WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public String PAGE_TITLE;
    public String PAGE_URL;


    public BaseExtendablePage(WebDriver driver){
        this.driver = driver;
        jsExecutor = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, 5, 1000);
        PageFactory.initElements(driver, this);
    }

    public void loadPage(){
        driver.get(getPageURL());
        Assert.assertEquals(driver.getTitle(), getPageTitle());
    }

    public String getPageURL(){ return PAGE_URL; }

    public String getPageTitle(){
        return PAGE_TITLE;
    }

    public void setTextOnElement(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void clickOnElement(WebElement element){
        Waits.visibilityOfElement(element);
        element.click();
    }

    public void selectValueFromDropdown(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void captureScreenshot(String screenShotName){
        try{
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("D:\\DemoQA\\TestsResults\\TestsResults" + screenShotName + ".png"));
            TestLogger.log.debug("Screenshot taken " + screenShotName + ".png");
        }
        catch (Exception e){
            TestLogger.log.error("Exception while taking screenshot \n" + e.getMessage());
        }
    }

}