package SmokeTests;

import BaseTest.ConfigurationForBrowser;
import Pages.RegistrationPage;
import Utilities.TestListener;
import org.testng.annotations.*;

/**
 * Created by Dawidek on 2018-01-30.
 */

@Listeners(TestListener.class)
public class RegistrationTest extends ConfigurationForBrowser{

    /*
    HashMap<String, String> registrationMap;

    @Factory(dataProvider = "registration", dataProviderClass = DemoQAdata.class)
    public RegistrationTest(String firstName, String lastName, String country){
        registrationMap = new HashMap<String, String>();
        registrationMap.put("firstName", firstName);
        registrationMap.put("lastName", lastName);
        registrationMap.put("country", country);
    }
    */

    @Test(groups = "logging")
    public void testLoginRegistrationPage() throws Exception{

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.loadPage();
        registrationPage.setTextFirstNameField("Michal");
        //registrationPage.setTextFirstNameField(registrationMap.get("firstName"));
        registrationPage.setTextLastNameField("Kowalewski");
        //registrationPage.setTextLastNameField(registrationMap.get("lastName"));
        registrationPage.clickMaritalRadioButton();
        registrationPage.tickAllCheckboxHobbies();
        registrationPage.selectCountryFromList("Poland");
        //registrationPage.selectCountryFromList(registrationMap.get("country"));
        registrationPage.fillDateOfBirth("1", "10", "2014");
        registrationPage.setTextOnPhoneNumberField("1234567890123");
        registrationPage.setRandomTextOnUserNameField();
        registrationPage.setRandomTextOnEmailField();
        registrationPage.fillthePasswordsFields("asdfghjkl1234.,");
        registrationPage.addAttachment("D://DemoQA//AutoIT//Fileupload.exe", "IMG_20170930_174713.jpg"); //dorobic dla Chrome i Mozilli(inna nazwa okna windowsowego, dla mozilli js executor)
        registrationPage.clickSubmitButton();
        registrationPage.verifyLoggingHeader();
    }


}
