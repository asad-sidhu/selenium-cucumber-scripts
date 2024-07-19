package StepDefinitions;

import Misc.Constants;
import PageObjects.WebTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static StepDefinitions.Hooks.getDriver;

public class WebTableSteps {

    private WebTablePage webTablePage = new WebTablePage(getDriver());

    @Given("The user is on the webtables page")
    public void userIsOnWebTablesPage() {
        if (!getDriver().getCurrentUrl().equals(Constants.WEBTABLESURL)) {
            getDriver().get(Constants.WEBTABLESURL);
        }
    }

    @When("The user clicks the {string} button")
    public void userClicksAddButton(String buttonName) {
        webTablePage.clickAddRecordButton();
    }

    @And("The user fills in the account details")
    public void userFillsAccountDetails(DataTable table) throws InterruptedException {
        List<Map<String,String>>  data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String firstName = row.get("firstname");
            String lastName = row.get("lastname");
            String email = row.get("email");
            String age = row.get("age");
            String salary = row.get("salary");
            String department = row.get("department");


            // Use your webTablePage methods to enter the details
            webTablePage.enterFirstName(firstName);
            webTablePage.enterLastName(lastName);
            webTablePage.enterEmail(email);
            webTablePage.enterAge(age);
            webTablePage.enterSalary(salary);
            webTablePage.enterDepartment(department);
        }

    }

    @And("The user clicks submit")
    public void userClicksSubmit() {
        webTablePage.clickSubmitRecordButton();
    }

    @Then("The user should see the information in the table")
    public void userShouldSeeInformationInTable(DataTable table) {
        List<Map<String,String>>  data = table.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            System.out.println(row.get("firstname"));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("firstname")+"']")));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("lastname")+"']")));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("email")+"']")));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("age")+"']")));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("salary")+"']")));
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class = 'rt-td' and text() = '"+row.get("department")+"']")));
        }
    }

    @Then("The user should see the Mandatory Field alerts in all the fields")
    public void userShouldSeeMandatoryAlerts() {
        Assert.assertTrue(webTablePage.areMandatoryAlertsPresent());
    }

    // Helper class to represent user data
    public static class UserData {
        private String firstName;
        private String lastName;
        private String email;

        public UserData(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }
}
