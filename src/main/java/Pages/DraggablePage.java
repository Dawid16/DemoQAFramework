package Pages;

import Commands.TableSectionDraggablePage;
import Utilities.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class DraggablePage extends BaseExtendablePage {

    @FindBy(xpath = "//a[@href= '#tabs-1']") WebElement defaultFunctionalityTableHeader;
    @FindBy(xpath = "//a[@href= '#tabs-3']") WebElement constraintMovementTableHeader;
    @FindBy(xpath = "//a[@href= '#tabs-4']") WebElement cursorStyleTableHeader;
    @FindBy(xpath = "//a[@href= '#tabs-5']") WebElement eventsTableHeader;
    @FindBy(xpath = "//a[@href= '#tabs-7']") WebElement draggableSortableTableHeader;
    @FindBy(id = "draggabl") WebElement verticallyDraggableElementConstrainMovement;
    @FindBy(id = "draggabl2") WebElement horrizontallyDraggableElementConstrainMovement;
    @FindBy(id = "event-start") WebElement eventStartElement;
    @FindBy(id = "event-stop") WebElement eventStopElement;
    @FindBy(id = "event-drag") WebElement eventDragElement;

    public DraggablePage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Draggable | Demoqa";
        this.PAGE_URL = "http://demoqa.com/draggable";
    }

    public void goToParticularTableSection(TableSectionDraggablePage tableSectionDraggablePage) {
        switch (tableSectionDraggablePage) {
            case DefaultFunctionality:
                clickOnElement(defaultFunctionalityTableHeader);
                break;
            case ConstrainMovement:
                clickOnElement(constraintMovementTableHeader);
                break;
            case CursorStyle:
                clickOnElement(cursorStyleTableHeader);
                break;
            case Events:
                clickOnElement(eventsTableHeader);
                break;
            case DraggableSortable:
                clickOnElement(draggableSortableTableHeader);
                break;
        }
        TestLogger.log.info(tableSectionDraggablePage + " clicked");
    }


    public void dragAndCheckHorizontalElem(int horizontally) {
        dragAndDropElement(horrizontallyDraggableElementConstrainMovement, horizontally, 0);
        Assert.assertTrue(horrizontallyDraggableElementConstrainMovement.getAttribute("style").contains(horizontally + "px"));
    }

    public void dragAndCheckVerticalElem(int vertically) {
        dragAndDropElement(verticallyDraggableElementConstrainMovement, 0, vertically);
        Assert.assertTrue(verticallyDraggableElementConstrainMovement.getAttribute("style").contains(vertically + "px"));
    }


    public void checkEventsDragging(int horizontally, int vertically) {

        List<WebElement> dragElements = Arrays.asList(eventDragElement, eventStartElement, eventStopElement);
        for (int i = 1; i <= dragElements.size(); i++) {
            dragAndDropElement(dragElements.get(i - 1), horizontally, vertically);
            Assert.assertTrue(dragElements.get(0).getText().contains(i + "x"));
            Assert.assertTrue(dragElements.get(1).getText().contains(i + "x"));
            Assert.assertTrue(dragElements.get(2).getText().contains(i + "x"));
            TestLogger.log.info(dragElements.get(i - 1) + " was dragged");
            vertically = vertically - 2 * vertically;
            horizontally = horizontally - 2 * horizontally;
        }

    }


}
