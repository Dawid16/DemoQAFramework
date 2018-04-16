package ElementsStrings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dawidek on 2018-03-20.
 */
public class DraggablePageObjects {

    @FindBy(id = "ui-id-1")
    static WebElement defaultFunctionalityTableHeader;

    public static WebElement getDefaultFunctionalityTableHeader() {
        return defaultFunctionalityTableHeader;
    }


}
