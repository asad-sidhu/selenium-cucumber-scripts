package PageObjects;

import Misc.Constants;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Misc.Methods.*;
import static StepDefinitions.Hooks.getDriver;

public class StudentFormPage extends BaseClass {

    public StudentFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By genderMale = By.xpath("//label[text()='Male']");
    private final By genderFemale = By.xpath("//label[text()='Female']");
    private final By genderOther = By.xpath("//label[text()='Other']");
    private final By mobileField = By.id("userNumber");
    private final By dobField = By.id("dateOfBirthInput");
    private final By subjectsField = By.id("subjectsInput");
    private final By hobbiesSports = By.xpath("//label[text()='Sports']");
    private final By hobbiesReading = By.xpath("//label[text()='Reading']");
    private final By hobbiesMusic = By.xpath("//label[text()='Music']");
    private final By currentAddressField = By.id("currentAddress");
    private final By uploadPictureBtn = By.id("uploadPicture");
    private final By stateDropdown = By.xpath("(//*[contains(@id,'react-select')])[1]");
    private final By cityDropdown = By.xpath("(//*[contains(@id,'react-select')])[2]");
    private final By submitButton = By.id("submit");
    private final By successMEssage = By.xpath("//*[contains(text(), 'Thanks for submitting the form')]");
    private final By pictureName = By.xpath("//tr/td[text()='Picture']/following-sibling::td");
    JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public void navigateToStudentFormPage() {
        getDriver().get(Constants.STUDENTFORMURL); // Replace with actual URL
    }

    public void enterFirstName(String firstName) {
        type(firstNameField,firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameField,lastName);
    }

    public void enterEmail(String email) {
        type(emailField,email);
    }

    public void enterPhoneNumber(String phone) {
        type(mobileField,phone);
    }

    public void enterDOB(String dob) throws InterruptedException {
        click(dobField);
        doubleKeyAction(Keys.CONTROL,"a ");
        type(dobField,dob);
        Thread.sleep(1000);
        enterKey(dobField);
    }

    public void enterSubjects(List<String> subjects) throws InterruptedException {
        for (String subject: subjects) {
            click(subjectsField);
            type(subjectsField,subject);
            Thread.sleep(500);
            pressEnter();
            Thread.sleep(1500);
        }
    }

    public void enterCurrentAddress(String address) {
        type(currentAddressField,address);
    }

    public void enterState(String state) {
        type(stateDropdown,state);
        pressEnter();
    }

    public void enterCity(String city) {
        type(cityDropdown,city);
        pressEnter();
    }

    public void selectGender(String gender) {
        click(By.xpath("//label[text()='" + gender + "']"));
    }

    public void selectHobbies(List<String> hobbies) {
        for (String hobby: hobbies) {
            click(By.xpath("//label[text()='" + hobby + "']"));
        }
    }

    public boolean verifySuccessMessage() throws InterruptedException {
        return isDisplayed(successMEssage);
    }

    public void clickSubmitRecordButton() throws InterruptedException {
         click(submitButton);
    }

    public boolean isMandatory(String field){
        switch (field){
           case "First Name":
                return getDriver().findElement(firstNameField).getAttribute("required")!= null;
           case "Last Name":
                return getDriver().findElement(lastNameField).getAttribute("required")!= null;
           case "Mobile":
                return getDriver().findElement(mobileField).getAttribute("required")!= null;
           case "Gender":
                return getDriver().findElement(By.id("gender-radio-1")).getAttribute("required")!= null;
            default:
                return false;
        }
    }

    public boolean isEmailValid(){
        return (Boolean) js.executeScript("return arguments[0].checkValidity();", getDriver().findElement(emailField));
    }

    public boolean isPhoneValid(){
        return (Boolean) js.executeScript("return arguments[0].checkValidity();", getDriver().findElement(mobileField));
    }

    public void uploadPicture(){
        type(uploadPictureBtn,getAbsolutePath(Constants.RESOURCESFOLDER+"Screenshot 2024-07-21 182232.png"));
    }

    public boolean isPictureUploaded(){
        String pictureText = getText(pictureName);
        return pictureText != null && !pictureText.trim().isEmpty();    }


}