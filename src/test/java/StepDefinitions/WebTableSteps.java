package StepDefinitions;

import Misc.Constants;
import PageObjects.WebTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static StepDefinitions.Hooks.getDriver;

public class WebTableSteps {

    private WebTablePage webTablePage = new WebTablePage(getDriver());
    private int initialCount;


    @Given("The user is on the webtables page")
    public void userIsOnWebTablesPage() {
//        if (!getDriver().getCurrentUrl().equals(Constants.WEBTABLESURL)) {
            getDriver().get(Constants.WEBTABLESURL);
//        }
    }

    @When("The user clicks the Add button")
    public void userClicksAddButton() {
        webTablePage.clickAddRecordButton();
    }

    @When("The user clicks the Edit button")
    public void userClicksEditButton() {
        webTablePage.clickEditRecordButton();
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

    @And("The user types in the searchbox")
    public void userTypesSearchQuery(DataTable table) throws InterruptedException {
        List<Map<String,String>>  data = table.asMaps(String.class, String.class);
        for (Map<String,String> row : data) {
            String searchQuery = row.get("searchQuery");
            webTablePage.enterSearchQuery(searchQuery);
            Thread.sleep(1000);
        }
    }

    @And("The user should see the search results in the table")
    public void verifySearchResults(DataTable table) throws InterruptedException {
        List<Map<String,String>>  data = table.asMaps(String.class, String.class);
        for (Map<String,String> row : data){
            String searchQuery = row.get("searchQuery");
            Assert.assertTrue(webTablePage.isDisplayed(By.xpath("//div[@class='rt-tbody']//*[contains(@class, 'rt-td') and contains (text(), '"+searchQuery+"')]")));
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

    @Then("The user should see the updated information in the table")
    public void userShouldSeeUpdatedInformationInTable(DataTable table) {
        List<WebElement> actualDataElements = getDriver().findElements(By.xpath("(//*[contains(@class, 'rt-tr') and contains(@class, '-odd')])[1]/div[not(*)]"));
        Map<String,String>  expectedData = table.asMaps(String.class, String.class).get(0);
            Assert.assertEquals(expectedData.get("firstname"),actualDataElements.get(0).getText());
            Assert.assertEquals(expectedData.get("lastname"),actualDataElements.get(1).getText());
        Assert.assertEquals(expectedData.get("age"),actualDataElements.get(2).getText());
        Assert.assertEquals(expectedData.get("email"),actualDataElements.get(3).getText());
            Assert.assertEquals(expectedData.get("salary"),actualDataElements.get(4).getText());
            Assert.assertEquals(expectedData.get("department"),actualDataElements.get(5).getText());
    }

    @Then("The user should see the Mandatory Field alerts in all the fields")
    public void userShouldSeeMandatoryAlerts() {
        Assert.assertTrue(webTablePage.areMandatoryAlertsPresent());
    }

    @When("User takes count of the records")
    public void user_takes_count_of_the_records() {
        initialCount = webTablePage.totalRecordCount();
        System.out.println(initialCount);
    }

    @When("The user clicks the Delete button")
    public void the_user_clicks_the_delete_button() {
        webTablePage.clickDeleteRecordButton();
    }

    @Then("The Record should be Deleted")
    public void  the_record_should_be_deleted() {
        int countAfterDeletion = webTablePage.totalRecordCount();
        Assert.assertEquals(initialCount-1,countAfterDeletion);
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
