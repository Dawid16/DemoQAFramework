package Pages;

import Utilities.RandomValuesGenerator;
import Utilities.TestLogger;
import Utilities.Waits;
import junitx.util.PropertyManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Dawidek on 2018-01-31.
 */
public class RegistrationPage extends BaseExtendablePage {

    @FindBy(id = "name_3_firstname") protected WebElement firstNameField;
    @FindBy(id = "name_3_lastname") protected WebElement lastNameField;
    @FindBy(xpath = "//input[@value = 'married']") WebElement maritalRadioButton;
    @FindBy(xpath = "//input[@type = 'checkbox']") List<WebElement> hobbyCheckBox;
    @FindBy(id = "dropdown_7")  WebElement countryDropDown;
    @FindBy(id = "phone_9") WebElement phoneNumberField;
    @FindBy(id = "username") WebElement userNameField;
    @FindBy(id = "email_1") WebElement emailField;
    @FindBy(id = "password_2") WebElement passwordField;
    @FindBy(id = "confirm_password_password_2") WebElement confirmationPasswordField;
    @FindBy(xpath = "//input[@name = 'pie_submit']") WebElement submitButton;
    @FindBy(id = "dd_date_8") WebElement dayDropDown;
    @FindBy(id = "mm_date_8") WebElement monthDropDown;
    @FindBy(id = "yy_date_8") WebElement yearDropDown;
    @FindBy(id = "profile_pic_10") WebElement addAttachmentButton;
    @FindBy(className = "piereg_message") WebElement registeredCorrectHeader;
    @FindBy(className = "piereg_login_error") WebElement registeredIncorrectHeader;


    public RegistrationPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Registration | Demoqa";
        this.PAGE_URL = "http://demoqa.com/registration/";
    }

    public void setTextFirstNameField(String text){
        setTextOnElement(firstNameField, text);
        TestLogger.log.info("Text set in FirstNameField: "+ text);
    }

    public void setTextLastNameField(String text){
        setTextOnElement(lastNameField, text);
        TestLogger.log.info("Text set in FirstNameField: "+ text);
    }

    public void clickMaritalRadioButton(){
        clickOnElement(maritalRadioButton);
        TestLogger.log.info("Marital radioButton clicked");
    }

    public void tickAllCheckboxHobbies(){
        List<WebElement> elements = hobbyCheckBox;
        Assert.assertEquals(3, elements.size());

        for(WebElement checkBox : elements) {
            clickOnElement(checkBox);
            TestLogger.log.info("CheckBox " + checkBox.getAttribute("value") + " was clicked");
        }
    }

    public void selectCountryFromList(String country){
        selectValueFromDropdown(countryDropDown, country);
        TestLogger.log.info("Country: " + country + " was clicked");
    }

    public void setTextOnPhoneNumberField(String phoneNumber){
        setTextOnElement(phoneNumberField, phoneNumber);
        TestLogger.log.info("Phone number: " + phoneNumber + " was typed");
    }

    public void setRandomTextOnUserNameField(){
        String userName = RandomValuesGenerator.generateRandomUserName();
        setTextOnElement(userNameField, userName);
        TestLogger.log.info("Username: " + userName + " was typed");
    }

    public void setRandomTextOnEmailField(){
        String email = RandomValuesGenerator.generateRandomEmail();
        setTextOnElement(emailField, email);
        TestLogger.log.info("Username: " + email + " was typed");
    }

    public void fillthePasswordsFields(String pass){
        setTextOnElement(passwordField, pass);
        setTextOnElement(confirmationPasswordField, pass);
        TestLogger.log.info("Password: " + pass + " was typed");
    }

    public void clickSubmitButton() {
        Waits.visibilityOfElement(submitButton);
        clickOnElement(submitButton);
        TestLogger.log.info("Submit button clicked");
    }

    public void fillDateOfBirth(String day, String month, String year) {
        selectValueFromDropdown(dayDropDown, day);
        selectValueFromDropdown(monthDropDown, month);
        selectValueFromDropdown(yearDropDown, year);
        TestLogger.log.info("Date of birth: " + day + " " + month + " " + year + " was chosen");
    }

    public void addAttachment(String pathToAttachment, String attName) throws Exception{
        if(PropertyManager.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            jsExecutor.executeScript("arguments[0].click();", addAttachmentButton);
            //Runtime for Mozilla TODO
        } else {
            addAttachmentButton.click();
            Thread.sleep(1000);
            Runtime.getRuntime().exec(pathToAttachment);
        }
        wait.until(ExpectedConditions.attributeContains(addAttachmentButton, "value", "C:"));
        Assert.assertEquals(addAttachmentButton.getAttribute("value"), "C:\\fakepath\\" + attName);
        TestLogger.log.info("Attachment added: " + addAttachmentButton.getAttribute("value"));
    }

    public boolean verifyLoggingHeader() {
        try {
            if(registeredCorrectHeader.isDisplayed()){
                TestLogger.log.info("Correctly registered - OK");
            }
            else if(registeredIncorrectHeader.isDisplayed()){
                TestLogger.log.info("Incorrectly registered - OK");    // poprawic metode
            }
        } catch(NoSuchElementException e){
            return false;
        }
        return false;
    }

}
