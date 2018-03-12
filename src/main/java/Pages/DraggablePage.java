package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class DraggablePage extends BaseExtendablePage {

    public DraggablePage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Draggable | Demoqa";
        this.PAGE_URL = "http://demoqa.com/draggable";
    }
}
