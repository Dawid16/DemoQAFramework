package Pages;

import Commands.TableSectionResizablePage;
import Utilities.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by Dawidek on 2018-03-27.
 */
public class ResizablePage extends BaseExtendablePage {

    @FindBy(id = "ui-id-1") WebElement defaultFunctionalityTableHeader;
    @FindBy(id = "ui-id-2") WebElement animateTableHeader;
    @FindBy(id = "ui-id-3") WebElement constrainResizeAreaTableHeader;
    @FindBy(id = "ui-id-4") WebElement helperTableHeader;
    @FindBy(id = "ui-id-5") WebElement maxMinSizeTableHeader;

    @FindBy(xpath = "//div[@id='resizable']/descendant::div[3]") WebElement resizableHandlerDF;
    @FindBy(id = "resizable") WebElement resizableElementDF;
    @FindBy(xpath = "//div[@id='resizableani']/descendant::div[3]") WebElement resizableHandlerA;
    @FindBy(id = "resizableani") WebElement resizableElementA;

    public ResizablePage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Resizable | Demoqa";
        this.PAGE_URL = "http://demoqa.com/resizable";
    }

    public void goToParticularTableSection(TableSectionResizablePage tableSectionResizablePage) {
        switch (tableSectionResizablePage) {
            case DefaultFunctionality:
                clickOnElement(defaultFunctionalityTableHeader);
                break;
            case Animate:
                clickOnElement(animateTableHeader);
                break;
            case ConstrainResizeArea:
                clickOnElement(constrainResizeAreaTableHeader);
                break;
            case Helper:
                clickOnElement(helperTableHeader);
                break;
            case MaxMinSize:
                clickOnElement(maxMinSizeTableHeader);
                break;
        }
        TestLogger.log.info(tableSectionResizablePage + " clicked");
    }

    public void resizeDefaultFunctionalityHandler(int xOffset, int yOffset) {
        scrollIntoView(resizableElementDF);
        resizeElement(resizableHandlerDF, xOffset, yOffset);
        Assert.assertTrue(resizableElementDF.getSize().getHeight() != yOffset && resizableElementDF.getSize().getWidth() != xOffset);
        TestLogger.log.info(resizableElementDF + " resized");
    }

    public void resizeAnimateHandler(int xOffset, int yOffset) {
        scrollIntoView(resizableElementA);
        resizeElement(resizableHandlerA, xOffset, yOffset);
        Assert.assertTrue(resizableElementA.getSize().getHeight() != yOffset && resizableElementA.getSize().getWidth() != xOffset);
        TestLogger.log.info(resizableElementA + " resized");
    }


}
