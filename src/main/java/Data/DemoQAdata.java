package Data;

import org.testng.annotations.DataProvider;

/**
 * Created by Dawidek on 2017-07-11.
 */
public class DemoQAdata {

    @DataProvider(name = "pages")
    public static Object[][] pages() {
        return new Object[][]{
                {"Thank you for your registration"},
                {": Username already exists"}
        };
    }

    @DataProvider(name = "registration")
    public static Object[][] login() {
        return new Object[][]{
                {"dawid", "kriupex", "Poland"},
                {"jsdkjbgskdfjhbgksdjbg", "inka", "Spain"},
                {"@#$@#$@#$", "rawska", "Portugal"},


        };
    }
}