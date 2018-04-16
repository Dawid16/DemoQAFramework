package Navigation;

import Pages.BaseExtendablePage;
import Utilities.TestLogger;
import Utilities.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Dawidek on 2018-03-28.
 */
public class MenuSelectorMenuPage extends BaseExtendablePage {

    public static void select(WebElement topMenuElement, WebElement subMenuElement) throws Exception {
        actions.moveToElement(topMenuElement).perform();
        TestLogger.log.info("Moved to element: " + topMenuElement.getText());
        TestLogger.log.info("Clicking on sub element:" + subMenuElement.getText());
        clickOnElement(subMenuElement);
        TestLogger.log.info("Sub menu element clicked");
    }

    public static void select(WebElement topMenuElement) throws Exception {
        clickOnElement(topMenuElement);
        TestLogger.log.info(topMenuElement.getText() + " clicked");
    }
}
