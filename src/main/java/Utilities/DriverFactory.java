package Utilities;

import junitx.util.PropertyManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.URL;

/**
 * Created by Dawidek on 2018-01-30.
 */
public class DriverFactory {

    public enum BrowserType {
        FIREFOX("firefox"),
        CHROME("chrome"),
        IE("internet_explorer"),
        SAFARI("safari"),
        HEADLESS("headless");

        private String value;

        BrowserType(String value) {
            this.value = value;
        }

        public String getBrowserName() {
            return this.value;
        }

    }

    public static WebDriver getDriver(BrowserType type) throws Exception {

        if (PropertyManager.getProperty("USE_GRID").equalsIgnoreCase("true")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(type.getBrowserName());
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        }

        switch (type) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "D://DemoQA//drivers//geckodriver.exe");
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "D://DemoQA//drivers//chromedriver.exe");
                return new ChromeDriver();
            case IE:
                return new InternetExplorerDriver();
            case SAFARI:
                return new SafariDriver();
            case HEADLESS:
                File source = new File("D://DemoQA//drivers//phantomjsWindows//bin//phantomjs.exe");
                System.setProperty("phantomjs.binary.path", source.getAbsolutePath());
                return new PhantomJSDriver();
            default:
                System.setProperty("webdriver.chrome.driver", "D://DemoQA//drivers//chromedriver.exe");
                return new ChromeDriver();
        }
    }

    public static BrowserType getBrowserTypeByProperty() {
        BrowserType type = null;
        String browserName = (StringUtils.isNotEmpty(System.getenv("BROWSER"))) ? System.getenv("BROWSER") : junitx.util.PropertyManager.getProperty("BROWSER");
        for (BrowserType bType : BrowserType.values()) {
            if (bType.getBrowserName().equalsIgnoreCase(browserName)) {
                type = bType;
                TestLogger.log.info("BROWSER = " + type.getBrowserName());
            }
        }
        return type;
    }

}


