package Navigation;

import Pages.BaseExtendablePage;
import org.openqa.selenium.WebElement;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class MenuSelectorHomePage extends BaseExtendablePage {

    public static void select(WebElement topMenuId, WebElement subMenuItem) {
        clickOnElement(topMenuId);
        clickOnElement(subMenuItem);
    }

}
