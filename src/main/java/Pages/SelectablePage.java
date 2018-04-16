package Pages;

import Commands.TableSectionSelectablePage;
import Utilities.TestLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Dawidek on 2018-03-26.
 */
public class SelectablePage extends BaseExtendablePage {

    @FindBy(id = "ui-id-1")
    WebElement defaultFunctionalityTableHeader;
    @FindBy(id = "ui-id-2")
    WebElement displayAsGridTableHeader;
    @FindBy(id = "ui-id-3")
    WebElement serializeTableHeader;

    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 1')]")
    WebElement item1WidgetSerialize;
    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 2')]")
    WebElement item2WidgetSerialize;
    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 3')]")
    WebElement item3WidgetSerialize;
    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 4')]")
    WebElement item4WidgetSerialize;
    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 5')]")
    WebElement item5WidgetSerialize;
    @FindBy(xpath = "//ol[@id='selectable-serialize']/li[contains(text(), 'Item 6')]")
    WebElement item6WidgetSerialize;
    @FindBy(xpath = "//span[@id='select-result']")
    WebElement selectableArea;
    @FindBy(xpath = "//ol/li[contains(@class,'ui-state-default')]")
    List<WebElement> displayAsGridElements;

    public SelectablePage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Selectable | Demoqa";
        this.PAGE_URL = "http://demoqa.com/selectable";
    }

    public void goToParticularTableSection(TableSectionSelectablePage tableSectionSelectablePage) {
        switch (tableSectionSelectablePage) {
            case DefaultFunctionality:
                clickOnElement(defaultFunctionalityTableHeader);
                break;
            case DisplayAsGrid:
                clickOnElement(displayAsGridTableHeader);
                break;
            case Serialize:
                clickOnElement(serializeTableHeader);
                break;
        }
        TestLogger.log.info(tableSectionSelectablePage + " clicked");
    }

    public void selectAllSerializeItems() {
        List<WebElement> serializeElements = Arrays.asList(item1WidgetSerialize, item2WidgetSerialize, item3WidgetSerialize, item4WidgetSerialize, item5WidgetSerialize, item6WidgetSerialize);
        actions.keyDown(Keys.LEFT_CONTROL);
        for (WebElement element : serializeElements) {
            actions.click(element).build().perform();
            Assert.assertTrue(element.getAttribute("class").contains("ui-selected"));
            TestLogger.log.info(element.getText() + " was marked");
        }
        actions.keyUp(Keys.LEFT_CONTROL);
    }

    public void selectAllDisplayAsGridItems() {
        actions.keyDown(Keys.LEFT_CONTROL);
        for (WebElement element : displayAsGridElements) {
            actions.click(element).build().perform();
            Assert.assertTrue(element.getAttribute("class").contains("ui-selected"));
            TestLogger.log.info(element.getText() + " was marked");
        }
        actions.keyUp(Keys.LEFT_CONTROL);
    }


}
