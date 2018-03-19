package SmokeTests;

import BaseTest.ConfigurationForBrowser;
import Commands.TableSectionDraggablePage;
import Commands.TableSectionDroppablePage;
import Pages.DraggablePage;
import Pages.DroppableBage;
import Pages.RegistrationPage;
import Utilities.TestLogger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Dawidek on 2018-02-15.
 */
public class AnotherTest extends ConfigurationForBrowser {

    @Test(groups = "logging")
    public void testReal() throws Exception{
        DraggablePage draggablePage = new DraggablePage(driver);
        DroppableBage droppableBage = new DroppableBage(driver);

        draggablePage.loadPage();
        draggablePage.goToParticularTableSection(TableSectionDraggablePage.ConstrainMovement);
        draggablePage.dragAndCheckHorizontalElem(100);
        draggablePage.dragAndCheckVerticalElem(100);

        droppableBage.loadPage();
        droppableBage.goToParticularTableSection(TableSectionDroppablePage.ShoppingCartDemo);
        droppableBage.addAllShirtsToCart();

    }
}
