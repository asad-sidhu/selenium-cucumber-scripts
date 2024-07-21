package PageObjects;

import Misc.Constants;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Misc.Methods.*;
import static StepDefinitions.Hooks.getDriver;

public class TextBoxPage extends BaseClass {

    public TextBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private final By fullNameField = By.cssSelector("input#userName");
    private final By emailField = By.cssSelector("input#userEmail");
    private final By currentAddressField = By.cssSelector("textarea#currentAddress");
    private final By permanentAddressField = By.cssSelector("textarea#permanentAddress");
    private final By submitButton = By.id("submit");

    private final By outputFullName = By.cssSelector("p#name");
    private final By outputEmail = By.cssSelector("p#email");
    private final By outputCurrentAddress = By.cssSelector("p#currentAddress");
    private final By outputPermanentAddress = By.cssSelector("p#permanentAddress");



    public void navigateToTextBoxPage() {
        getDriver().get(Constants.TEXTBOXURL);
    }

    public void enterFullName(String fullName) {
        type(fullNameField,fullName);
    }

    public void enterEmail(String email) {
        type(emailField,email);
    }

    public void enterCurrentAddress(String currentAddress) {
        type(currentAddressField,currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        type(permanentAddressField,permanentAddress);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public boolean isInvalidEmailAlertPresent() {
        return getDriver().findElement(emailField).getAttribute("class").contains("field-error");
    }

    public String getOutputFullName() {
        return getText(outputFullName).split(":")[1];
    }

    public String getOutputEmail() {
        return getText(outputEmail).split(":")[1];
    }

    public String getOutputCurrentAddress() {
        return getText(outputCurrentAddress).split(":")[1];
    }

    public String getOutputPermanentAddress() {
        return getText(outputPermanentAddress).split(":")[1];
    }

}