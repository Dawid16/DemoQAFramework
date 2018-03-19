package Navigation;

import Pages.BaseExtendablePage;
import org.openqa.selenium.WebElement;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class MenuSelector extends BaseExtendablePage {

    public static void select(WebElement topMenuId, WebElement subMenuTextLink) {
        clickOnElement(topMenuId);
        clickOnElement(subMenuTextLink);
    }

    public static void selectFromTableDraggablePage(WebElement tableName) {
        clickOnElement(tableName);
    }


}
