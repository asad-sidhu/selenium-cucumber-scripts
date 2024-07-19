package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Misc.Methods.click;
import static Misc.Methods.type;
import static StepDefinitions.Hooks.getDriver;

public class WebTablePage extends BaseClass {

    public WebTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private By addNewRecordBtn = By.id("addNewRecordButton");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By ageField = By.id("age");
    private By salaryField = By.id("salary");
    private By departmentField = By.id("department");
    private By submitRecordBtn = By.id("submit");
    private By userRecordForm = By.id("userForm");


    public  void clickAddRecordButton() {
        click(addNewRecordBtn);
    }

    public  void clickSubmitRecordButton() {
        click(submitRecordBtn);
    }

    public  void enterFirstName(String fname) {
        type(firstNameField,fname);
    }

    public  void enterLastName(String lname) {
       type(lastNameField,lname);
    }

   public  void enterEmail(String email) {
       type(emailField,email);
    }

   public  void enterAge(String age) {
       type(ageField,age);
    }

   public  void enterSalary(String salary) {
       type(salaryField,salary);
    }

   public  void enterDepartment(String department) {
       type(departmentField,department);
    }

    public boolean isDisplayed(By locator) {
        return getDriver().findElement(locator).isDisplayed();
    }

    public boolean areMandatoryAlertsPresent() {
        List<WebElement> inputs = getDriver().findElement(userRecordForm).findElements(By.cssSelector("input"));
        boolean present = false;
        for (WebElement input: inputs) {
            present = input.getAttribute("required") != null;
        }
        return present;
    }
}