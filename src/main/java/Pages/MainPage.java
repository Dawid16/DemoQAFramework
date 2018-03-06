package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dawidek on 2018-02-13.
 */
public class MainPage extends BaseExtendablePage {

    public MainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Demoqa | Just another WordPress site";
        this.PAGE_URL = "http://demoqa.com";
    }


}
