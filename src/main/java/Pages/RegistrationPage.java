package Pages;

import Utilities.RandomValuesGenerator;
import Utilities.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Dawidek on 2018-01-31.
 */
public class RegistrationPage extends BaseExtendedPage {

    @FindBy(id = "name_3_firstname") WebElement firstNameField;
    @FindBy(id = "name_3_lastname") WebElement lastNameField;
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
    }

    public void setTextLastNameField(String text){
        setTextOnElement(lastNameField, text);
    }

    public void clickMaritalRadioButton(){
        clickOnElement(maritalRadioButton);
    }

    public void tickAllCheckboxHobbies(){
        List<WebElement> elements = hobbyCheckBox;
        Assert.assertEquals(3, elements.size());

        for(WebElement checkBox : elements) {
            clickOnElement(checkBox);
            System.out.println("CheckBox " + checkBox.getAttribute("value") + " was clicked");
        }
    }

    public void selectCountryFromList(String country){
        selectValueFromDropdown(countryDropDown, country);
        System.out.println("Country " + country + " was clicked");
    }

    public void setTextOnPhoneNumberField(String phoneNumber){
        setTextOnElement(phoneNumberField, phoneNumber);
        System.out.println("Phone number: " + phoneNumber + " was typed");
    }

    public void setRandomTextOnUserNameField(){
        String userName = RandomValuesGenerator.generateRandomUserName();
        setTextOnElement(userNameField, userName);
        System.out.println("Username: " + userName + " was typed");
    }

    public void setRandomTextOnEmailField(){
        String email = RandomValuesGenerator.generateRandomEmail();
        setTextOnElement(emailField, email);
        System.out.println("Username: " + email + " was typed");
    }

    public void fillthePasswordsFields(String pass){
        setTextOnElement(passwordField, pass);
        setTextOnElement(confirmationPasswordField, pass);
        System.out.println("Password: " + pass + " was typed");
    }

    public void clickSubmitButton() {
        Waits.visibilityOfElement(submitButton);
        clickOnElement(submitButton);
    }

    public void fillDateOfBirth(String day, String month, String year) {
        selectValueFromDropdown(dayDropDown, day);
        selectValueFromDropdown(monthDropDown, month);
        selectValueFromDropdown(yearDropDown, year);
        System.out.println("Date of birth: " + day + " " + month + " " + year + " was chosen");
    }

    public void addAttachment(String pathToAttachment, String attName) throws Exception{
        Thread.sleep(1000);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;   //getBrowserName po tutorialach capabilities
        addAttachmentButton.click();
        // Thread.sleep(1000);
        //executor.executeScript("arguments[0].click();", el);  (dla Mozilli
        //addAttachmentButton.click();
        Thread.sleep(1000);                                                                 //zmienić później
        Runtime.getRuntime().exec(pathToAttachment);
        wait.until(ExpectedConditions.elementToBeClickable(addAttachmentButton));
        Assert.assertEquals(addAttachmentButton.getAttribute("value"), "C:\\fakepath\\" + attName);
        System.out.println("Attachment added: " + addAttachmentButton.getAttribute("value"));
    }

    public boolean verifyLoggingHeader() {
        try {
            if(registeredCorrectHeader.isDisplayed()){
                System.out.println("Correctly registered - OK");
            }
            else if(registeredIncorrectHeader.isDisplayed()){
                System.out.println("Incorrectly registered - OK");
            }
        } catch(NoSuchElementException e){
            return false;
        }
        return false;
    }

}
