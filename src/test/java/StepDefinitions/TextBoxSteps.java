package StepDefinitions;

import PageObjects.TextBoxPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static StepDefinitions.Hooks.getDriver;

public class TextBoxSteps {

    private TextBoxPage textBoxPage = new TextBoxPage(getDriver());

    @Given("The user is on the text box page")
    public void userIsOnTextBoxPage() {
        try {
            textBoxPage.navigateToTextBoxPage();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to navigate to the text box page: " + e.getMessage());
        }
    }

    @When("The user clicks the submit button")
    public void userClicksSubmitButton() {
        try {
            textBoxPage.clickSubmitButton();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button: " + e.getMessage());
        }
    }

    @When("The user fills in the form with valid data")
    public void userFillsInFormWithValidData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row : data) {
                textBoxPage.enterFullName(row.get("fullName"));
                textBoxPage.enterEmail(row.get("email"));
                textBoxPage.enterCurrentAddress(row.get("currentAddress"));
                textBoxPage.enterPermanentAddress(row.get("permanentAddress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form with valid data: " + e.getMessage());
        }
    }

    @Then("The user should see the submitted data in the output section")
    public void userShouldSeeSubmittedDataInOutputSection(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            // Extract values from the data table
            String fullName = row.get("fullName");
            String email = row.get("email");
            String currentAddress = row.get("currentAddress");
            String permanentAddress = row.get("permanentAddress");

            try {
                // Perform assertions based on whether permanentAddress is present
                if (permanentAddress != null && !permanentAddress.trim().isEmpty()) {
                    // Assert all fields when permanentAddress is provided
                    Assert.assertEquals("Full Name mismatch!", fullName, textBoxPage.getOutputFullName());
                    Assert.assertEquals("Email mismatch!", email, textBoxPage.getOutputEmail());
                    Assert.assertEquals("Current Address mismatch!", currentAddress, textBoxPage.getOutputCurrentAddress());
                    Assert.assertEquals("Permanent Address mismatch!", permanentAddress, textBoxPage.getOutputPermanentAddress());
                } else {
                    // Assert only the fields that are present when permanentAddress is not provided
                    Assert.assertEquals("Full Name mismatch!", fullName, textBoxPage.getOutputFullName());
                    Assert.assertEquals("Email mismatch!", email, textBoxPage.getOutputEmail());
                    Assert.assertEquals("Current Address mismatch!", currentAddress, textBoxPage.getOutputCurrentAddress());
                }
            } catch (AssertionError e) {
                // Print stack trace and fail the test with a detailed message
                e.printStackTrace();
                throw new AssertionError("Assertion failed: " + e.getMessage());
            } catch (Exception e) {
                // Print stack trace and fail the test with a general failure message
                e.printStackTrace();
                Assert.fail("Failed to verify submitted data in the output section: " + e.getMessage());
            }
        }
    }


    @When("The user fills in the form with invalid email")
    public void userFillsInFormWithInvalidEmail(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row : data) {
                textBoxPage.enterFullName(row.get("fullName"));
                textBoxPage.enterEmail(row.get("email"));
                textBoxPage.enterCurrentAddress(row.get("currentAddress"));
                textBoxPage.enterPermanentAddress(row.get("permanentAddress"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form with invalid email: " + e.getMessage());
        }
    }

    @Then("The user should see an invalid email alert")
    public void userShouldSeeInvalidEmailAlert() {
        try {
            Assert.assertTrue("Invalid email alert not present!", textBoxPage.isInvalidEmailAlertPresent());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify invalid email alert: " + e.getMessage());
        }
    }

    @When("The user fills in the form without permanent address")
    public void userFillsInFormWithoutPermanentAddress(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        try {
            for (Map<String, String> row : data) {
                textBoxPage.enterFullName(row.get("fullName"));
                textBoxPage.enterEmail(row.get("email"));
                textBoxPage.enterCurrentAddress(row.get("currentAddress"));
                textBoxPage.enterPermanentAddress(""); // No permanent address
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form without permanent address: " + e.getMessage());
        }
    }
}
