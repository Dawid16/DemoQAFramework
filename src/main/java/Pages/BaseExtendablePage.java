package Pages;

import Utilities.TestLogger;
import Utilities.Waits;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

/**
 * Created by Dawidek on 2018-02-04.
 */
public class BaseExtendablePage {

    public static WebDriver driver;
    public static  WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;
    public static Actions actions;

    public String PAGE_TITLE;
    public String PAGE_URL;


    public BaseExtendablePage(WebDriver driver) {
        this.driver = driver;
        jsExecutor = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, 5, 1000);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public BaseExtendablePage() {
    }

    public final void loadPage() {
        long start = System.currentTimeMillis();
        driver.get(getPageURL());
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        Assert.assertEquals(driver.getTitle(), getPageTitle());
        TestLogger.log.info(this.PAGE_TITLE + " loaded in " + totalTime + " miliseconds");
    }

    public String getPageURL() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public final void setTextOnElement(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public final static void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectValueFromDropdown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void captureScreenshot(String screenShotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("D:\\DemoQA\\TestsResults\\TestsResults" + screenShotName + ".png"));
            TestLogger.log.debug("Screenshot taken " + screenShotName + ".png");
        } catch (Exception e) {
            TestLogger.log.error("Exception while taking screenshot \n" + e.getMessage());
        }
    }

    public void dragAndDropElement(WebElement element, int horizontally, int vertically) {
        actions.dragAndDropBy(element, horizontally, vertically).build().perform();
        TestLogger.log.info(element.getText() + " was dragged");
    }

    public void dragAndDropElement(WebElement source, WebElement destination) {
        actions.clickAndHold(source).moveToElement(destination).release(destination).build().perform();
    }

    public void resizeElement(WebElement resizableElement, int xOffset, int yOffset) {
        actions.clickAndHold(resizableElement).moveByOffset(xOffset, yOffset).release().build().perform();

    }

    public static void scrollIntoView(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
        TestLogger.log.info("Scrolled into view of element: " + element);

    }


}
