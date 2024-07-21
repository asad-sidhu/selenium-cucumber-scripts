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
    private final By addNewRecordBtn = By.id("addNewRecordButton");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By ageField = By.id("age");
    private final By salaryField = By.id("salary");
    private final By departmentField = By.id("department");
    private final By submitRecordBtn = By.id("submit");
    private final By userRecordForm = By.id("userForm");
    private final By editRecordBtn = By.id("edit-record-1");
    private final By deleteRecordBtn = By.id("delete-record-1");


    public  void clickAddRecordButton() {
        click(addNewRecordBtn);
    }

    public  void clickEditRecordButton() {
        click(editRecordBtn);
    }

    public  void clickDeleteRecordButton() {
        click(deleteRecordBtn);
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

    public int totalRecordCount() {
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            List<WebElement> cells = getDriver().findElements(By.xpath("(//div[@class='rt-tbody']//*[contains(@class, 'rt-tr-group')])["+i+"]//div[@class='rt-td' and not(*)]")); // Relative XPath
            int count2 = 0;
            for (WebElement cell: cells) {
                if (!cell.getText().trim().equals("")) {
                    System.out.println("Non-empty cell text: " + cell.getText());
                    count2++;
                }
            }
            System.out.println("Non-empty cell count for this row: " + count2);
            if (count2 == 6) { // Check after inner loop
                count++;
                System.out.println("Total count incremented: " + count);
            }
        }
        System.out.println("Final total count of non-empty rows: " + count);
        return count;
    }

}