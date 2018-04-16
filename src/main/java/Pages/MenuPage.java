package Pages;

import Commands.TableSectionMenuPage;
import Navigation.TableHeadersMenuPage;
import Utilities.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dawidek on 2018-03-28.
 */
public class MenuPage extends BaseExtendablePage {

    @FindBy(id = "ui-id-1") public WebElement simpleMenu;
    @FindBy(id = "ui-id-2") public WebElement menuWithSubMenu;

    @FindBy(xpath = "//div[@id='tabs-1']//a[text()='Home']") public static WebElement homeButtonSimpleMenu;
    @FindBy(xpath = "//div[@id='tabs-1']//a[text()='About']") public static WebElement aboutButtonSimpleMenu;
    @FindBy(xpath = "//div[@id='tabs-1']//a[text()='Contact']") public static WebElement contactButtonSimpleMenu;
    @FindBy(xpath = "//div[@id='tabs-1']//a[text()='FAQ']") public static WebElement FAQButtonSimpleMenu;
    @FindBy(xpath = "//div[@id='tabs-1']//a[text()='News']") public static WebElement newsButtonSimpleMenu;

    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='Home']") public static WebElement homeButtonMenuWithSubMenu;
    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='About']") public static WebElement aboutButtonMenuWithSubMenu;
    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='Contact']") public static WebElement contactButtonMenuWithSubMenu;
    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='FAQ']") public static WebElement FAQButtonMenuWithSubMenu;
    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='News']") public static WebElement newsButtonMenuWithSubMenu;

    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='Sub Menu Item 1']") public static WebElement homeItem1MenuWithSubMenu;
    @FindBy(xpath = "//div[@id='tabs-2']//a[text()='Sub Menu Item 2']") public static WebElement homeItem2MenuWithSubMenu;

    @FindBy(xpath = "//li[@class='ui-corner-left']//li[3]") public static WebElement homeItem3aMenuWithSubMenu;
    @FindBy(xpath = "//li[@class='ui-corner-left']//li[4]") public static WebElement homeItem3bMenuWithSubMenu;

    @FindBy(xpath = "//li[4]//a[text()='Sub Menu Item 1']") public static WebElement FAQItem1MenuWithSubMenu;
    @FindBy(xpath = "//div[@id='content']//li[4]//li[2]") public static WebElement FAQItem3MenuWithSubMenu;

    @FindBy(xpath = "//li[5]//li[1]") public static WebElement newsItem1MenuWithSubMenu;
    @FindBy(xpath = "//li[5]//li[2]") public static WebElement newsItem2MenuWithSubMenu;
    @FindBy(xpath = "//li[5]//li[3]") public static WebElement newsItem3MenuWithSubMenu;


    public MenuPage(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Menu | Demoqa";
        this.PAGE_URL = "http://demoqa.com/menu/";
    }

    public MenuPage() {
    }

    public void goToNavTabDemo(TableSectionMenuPage tableSectionMenuPage) {
        switch (tableSectionMenuPage) {
            case SimpleMenu:
                clickOnElement(simpleMenu);
                break;
            case MenuWithSubMenu:
                clickOnElement(menuWithSubMenu);
                break;
        }

        TestLogger.log.info(tableSectionMenuPage + " selected");
    }

    public void checkMenuWithSubMenu() throws Exception {
        TableHeadersMenuPage.MenuWithSubMenuHome.SubMenuItem1.select();
        TableHeadersMenuPage.MenuWithSubMenuHome.SubMenuItem2.select();
        TableHeadersMenuPage.MenuWithSubMenuHome.SubMenuItem3a.select();
        TableHeadersMenuPage.MenuWithSubMenuHome.SubMenuItem3b.select();

        TableHeadersMenuPage.MenuWithSubMenuAbout.select();

        TableHeadersMenuPage.MenuWithSubMenuContact.select();

        TableHeadersMenuPage.MenuWithSubMenuFAQ.SubMenuItem1.select();
        TableHeadersMenuPage.MenuWithSubMenuFAQ.SubMenuItem3.select();

        TableHeadersMenuPage.MenuWithSubMenuNews.SubMenuItem1.select();
        TableHeadersMenuPage.MenuWithSubMenuNews.SubMenuItem2.select();
        TableHeadersMenuPage.MenuWithSubMenuNews.SubMenuItem3.select();
    }

    public void checkSimpleMenu() throws Exception{
        TableHeadersMenuPage.SimpleMenuHome.select();
        TableHeadersMenuPage.SimpleMenuAbout.select();
        TableHeadersMenuPage.SimpleMenuContact.select();
        TableHeadersMenuPage.SimpleMenuFAQ.select();
        TableHeadersMenuPage.SimpleMenuNews.select();

    }


}
