package SmokeTests;

import BaseTest.ConfigurationForBrowser;
import Commands.*;
import Pages.*;
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
        //DraggablePage draggablePage = new DraggablePage(driver);
        //DroppableBage droppableBage = new DroppableBage(driver);
        //SelectablePage selectablePage = new SelectablePage(driver);
        ResizablePage resizablePage = new ResizablePage(driver);
        MenuPage menuPage = new MenuPage(driver);

        menuPage.loadPage();
        menuPage.goToNavTabDemo(TableSectionMenuPage.SimpleMenu);
        menuPage.checkSimpleMenu();
        menuPage.goToNavTabDemo(TableSectionMenuPage.MenuWithSubMenu);
        menuPage.checkMenuWithSubMenu();
/*
        resizablePage.loadPage();
        resizablePage.goToParticularTableSection(TableSectionResizablePage.DefaultFunctionality);
        resizablePage.resizeDefaultFunctionalityHandler(200, 200);
        resizablePage.goToParticularTableSection(TableSectionResizablePage.Animate);
        resizablePage.resizeAnimateHandler(200,200);
        Thread.sleep(5000);*/




       /* selectablePage.loadPage();
        selectablePage.goToParticularTableSection(TableSectionSelectablePage.Serialize);
        selectablePage.selectAllSerializeItems();
        selectablePage.goToParticularTableSection(TableSectionSelectablePage.DisplayAsGrid);
        selectablePage.selectAllDisplayAsGridItems();*/
       /* draggablePage.loadPage();
        draggablePage.goToParticularTableSection(TableSectionDraggablePage.ConstrainMovement);
        draggablePage.dragAndCheckHorizontalElem(100);
        draggablePage.dragAndCheckVerticalElem(100);
        draggablePage.goToParticularTableSection(TableSectionDraggablePage.Events);
        draggablePage.checkEventsDragging(800, 50); */

        //droppableBage.loadPage();
        //droppableBage.goToParticularTableSection(TableSectionDroppablePage.ShoppingCartDemo);
        //droppableBage.addAllShirtsToCart();

    }
}
