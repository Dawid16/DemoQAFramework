package Pages;

import Commands.TableSectionDroppablePage;
import Utilities.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Dawidek on 2018-03-19.
 */
public class DroppableBage extends BaseExtendablePage {

    @FindBy(id = "ui-id-1") WebElement defaultFunctionalityTableHeader;
    @FindBy(id = "ui-id-2") WebElement acceptTableHeader;
    @FindBy(id = "ui-id-3") WebElement preventPropagationTableHeader;
    @FindBy(id = "ui-id-4") WebElement RevertDraggablePositionTableHeader;
    @FindBy(id = "ui-id-5") WebElement shoppingCartDemoTableHeader;

    @FindBy(xpath = "//li[@class='ui-corner-left ui-draggable ui-draggable-handle'][1]") WebElement lolcatShirt;
    @FindBy(xpath = "//li[@class='ui-corner-left ui-draggable ui-draggable-handle'][2]") WebElement cheezeBurgerShirt;
    @FindBy(xpath = "//li[@class='ui-corner-left ui-draggable ui-draggable-handle'][3]") WebElement buckitShirt;
    @FindBy(xpath = "//li[@class='ui-corner-left ui-draggable ui-draggable-handle'][contains(text(),'Shirt')]") List<WebElement> shirts;

    @FindBy(xpath = "//div[@class='ui-widget-content']")
    WebElement droppableZone;

    public DroppableBage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Droppable | Demoqa";
        this.PAGE_URL = "http://demoqa.com/droppable";
    }

    public void goToParticularTableSection(TableSectionDroppablePage tableSectionDroppablePage) {
        switch (tableSectionDroppablePage) {
            case DefaultFunctionality:
                clickOnElement(defaultFunctionalityTableHeader);
                break;
            case Accept:
                clickOnElement(acceptTableHeader);
                break;
            case PreventPropagation:
                clickOnElement(preventPropagationTableHeader);
                break;
            case RevertDraggablePosition:
                clickOnElement(RevertDraggablePositionTableHeader);
                break;
            case ShoppingCartDemo:
                clickOnElement(shoppingCartDemoTableHeader);
                break;
        }
        TestLogger.log.info(tableSectionDroppablePage + " clicked");
    }

    public void addElementToCart(WebElement element) throws Exception {
        dragAndDropElement(element, droppableZone);
        TestLogger.log.info("Element " + element.getText() + " was added to the cart");
        Assert.assertTrue(droppableZone.getText().contains(element.getText()));
    }

    public void addAllShirtsToCart() {
        List<WebElement> elements = shirts;
        Assert.assertEquals(3, elements.size());

        for (WebElement shirt : elements) {
            dragAndDropElement(shirt, droppableZone);
            Assert.assertTrue(droppableZone.getText().contains(shirt.getText()));
            TestLogger.log.info("Element " + shirt.getText() + " was added to the cart");
        }
        TestLogger.log.info("Elements in the cart: " + "\n" + droppableZone.getText());
    }

}
