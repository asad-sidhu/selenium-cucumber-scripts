package PageObjects;

import Misc.Constants;
import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Misc.Methods.*;
import static StepDefinitions.Hooks.getDriver;

public class ButtonsPage extends BaseClass {

    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private final By singleClickButton = By.xpath("//button[text()='Click Me']");
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By singleClickMessage = By.id("dynamicClickMessage");
    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");


    public void navigateToButtonsPage() {
        getDriver().get(Constants.BUTTONSURL); // Replace with actual URL
    }


    public void performSingleClick(){
        click(singleClickButton);
    }

    public void performDoubleClick() {
        doubleClick(doubleClickButton);
    }

    public void performRightClick() {
        rightClick(rightClickButton);
    }

    public String getOutputMessage(String action) {
        switch (action) {
            case "Single Click":
                return getText(singleClickMessage);
            case "Right Click":
                return getText(rightClickMessage);
            case "Double Click":
                return getText(doubleClickMessage);
            default:
                throw new IllegalArgumentException("Unsupported action: " + action);
        }
    }


    public String getDoubleClickOutputMessage() {
        return getText(doubleClickMessage);
    }

    public String getRightClickOutputMessage() {
        return getText(rightClickMessage);
    }
}