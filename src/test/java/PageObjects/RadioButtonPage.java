package PageObjects;

import Misc.Constants;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static Misc.Methods.*;
import static StepDefinitions.Hooks.getDriver;

public class RadioButtonPage extends BaseClass {

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private By yesRadioButton = By.xpath("//label[@for = 'yesRadio']");
    private By impressiveRadioButton = By.xpath("//label[@for = 'impressiveRadio']");
    private By noRadioButton = By.xpath("//label[@for = 'noRadio']");
    private By outputMessage = By.cssSelector(".col-12.mt-4.col-md-6 p");


    public void navigateToRadioButtonPage() {
        getDriver().get(Constants.RADIOBUTTONURL); // Replace with actual URL
    }

    public boolean isRadioButtonDisplayed(String option) throws InterruptedException {
        switch (option) {
           case "Yes":
                return isDisplayed(yesRadioButton);
            case "No":
                return isDisplayed(impressiveRadioButton);
           case "Impressive":
               return isDisplayed(noRadioButton);
            default:
                return false;
        }
    }

    public boolean isRadioButtonEnabled(String option) throws InterruptedException {
        return isEnabled(noRadioButton);
    }

    public void selectRadioButton(String option) {
        switch (option) {
            case "Yes":
                 click(yesRadioButton);
            case "Impressive":
                 click(impressiveRadioButton);
            case "No":
                 click(noRadioButton);
        }
    }

    public String getOutputMessage() {
        return getText(outputMessage);
    }
}