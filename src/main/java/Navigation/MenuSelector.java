package Navigation;

import org.openqa.selenium.By;

import static Pages.BaseExtendablePage.driver;


/**
 * Created by Dawidek on 2018-03-12.
 */
public class MenuSelector {


    public static void select(String topMenuId, String subMenuTextLink) {
        driver.findElement(By.xpath(topMenuId)).click();
        driver.findElement(By.xpath(subMenuTextLink)).click();
    }
}
