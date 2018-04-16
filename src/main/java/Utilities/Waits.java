package Utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Created by Dawidek on 2018-02-08.
 */
public class Waits {

    public static ExpectedCondition<Boolean> visibilityOfElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                } catch (NoSuchElementException e) {
                    return false;
                } catch (StaleElementReferenceException e1) {
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> elementHasText(final WebElement element) {
        return new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isEnabled();
                } catch (NoSuchElementException e) {
                    return false;
                } catch (StaleElementReferenceException e1) {
                    return false;
                }
            }
        };
    }
}
