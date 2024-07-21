package StepDefinitions;

import PageObjects.ButtonsPage;
import PageObjects.StudentFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static StepDefinitions.Hooks.getDriver;

public class StudentFormSteps {

    private StudentFormPage studentFormPage = new StudentFormPage(getDriver());

    @Given("The user is on the student form page")
    public void userIsOnStudentFormPage() {
        studentFormPage.navigateToStudentFormPage();
    }

    @When("The user fills in the student form with valid data")
    public void userFillsInFormWithValidData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> a = data.get(0);
        try {
            for (Map<String, String> row : data) {
                studentFormPage.enterFirstName(row.get("firstName"));
                studentFormPage.enterLastName(row.get("lastName"));
                studentFormPage.enterEmail(row.get("email"));
                studentFormPage.selectGender(row.get("gender"));
                studentFormPage.enterPhoneNumber(row.get("mobile"));
                studentFormPage.enterDOB(row.get("dateOfBirth"));
                List<String> subjects = Arrays.asList(row.get("subjects").split(", "));
                studentFormPage.enterSubjects(subjects);
                List<String> hobbies = Arrays.asList(row.get("hobbies").split(", "));
                studentFormPage.selectHobbies(hobbies);
                studentFormPage.enterCurrentAddress(row.get("currentAddress"));
                studentFormPage.enterState(row.get("state"));
                studentFormPage.enterCity(row.get("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form with valid data: " + e.getMessage());
        }
    }

    @Then("The form should be successfully submitted")
    public void the_form_should_be_successfully_submitted() throws InterruptedException {
        try {
            Assert.assertTrue("Success message not displayed", studentFormPage.verifySuccessMessage());
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure the test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify successful form submission: " + e.getMessage());
        }
    }

    @Then("The user should see a success message")
    public void the_user_should_see_a_success_message() throws InterruptedException {
        try {
            Assert.assertTrue("Success message not displayed", studentFormPage.verifySuccessMessage());
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure the test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify success message: " + e.getMessage());
        }
    }

    @Then("The user should see mandatory field validation messages with {string}, {string}, {string} and {string} fields")
    public void the_user_should_see_mandatory_validation_message(String field1, String field2, String field3, String field4) throws InterruptedException {
        try {
            Assert.assertTrue(field1 + " is not marked as mandatory", studentFormPage.isMandatory(field1));
            Assert.assertTrue(field2 + " is not marked as mandatory", studentFormPage.isMandatory(field2));
            Assert.assertTrue(field3 + " is not marked as mandatory", studentFormPage.isMandatory(field3));
            Assert.assertTrue(field4 + " is not marked as mandatory", studentFormPage.isMandatory(field4));
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure the test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify mandatory field validation messages: " + e.getMessage());
        }
    }

    @Then("The user clicks the submit button without filling in any data")
    public void user_click_submit_without_filling_any_field() throws InterruptedException {
        try {
            studentFormPage.clickSubmitRecordButton();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }

    @Then("The user clicks the submit button.")
    public void user_click_submit() throws InterruptedException {
        try {
            studentFormPage.clickSubmitRecordButton();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }


    @When("The user fills in the form with an invalid email")
    public void userFillsInFormWithInvalidEmail(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> a = data.get(0);
        System.out.println(a);
        try {
            for (Map<String, String> row : data) {
                studentFormPage.enterFirstName(row.get("firstName"));
                studentFormPage.enterLastName(row.get("lastName"));
                studentFormPage.enterEmail(row.get("email"));
                studentFormPage.selectGender(row.get("gender"));
                studentFormPage.enterPhoneNumber(row.get("mobile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form with valid data: " + e.getMessage());
        }
    }

    @Then("The user should see an invalid email validation message")
    public void validate_email_field() throws InterruptedException {
        try {
            Assert.assertFalse("Email validation failed: The email format is incorrect.", studentFormPage.isEmailValid());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }


    @When("The user fills in the form with invalid mobile number")
    public void userFillsInFormWithInvalidMobile(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> a = data.get(0);
        System.out.println(a);
        try {
            for (Map<String, String> row : data) {
                studentFormPage.enterFirstName(row.get("firstName"));
                studentFormPage.enterLastName(row.get("lastName"));
                studentFormPage.enterEmail(row.get("email"));
                studentFormPage.selectGender(row.get("gender"));
                studentFormPage.enterPhoneNumber(row.get("mobile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to fill in the form with valid data: " + e.getMessage());
        }
    }

    @Then("The user should see an invalid mobile number validation message")
    public void validate_mobile_field() throws InterruptedException {
        try {
            Assert.assertFalse("Mobile Number validation failed: The Mobile Number format is incorrect.", studentFormPage.isPhoneValid());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }

    @Then("The user uploads the picture")
    public void upload_picture() throws InterruptedException {
        try {
            studentFormPage.uploadPicture();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }

    @Then("The picture should be uploaded successfully")
    public void validate_picture_upload() throws InterruptedException {
        try {
            Assert.assertTrue("Picture Upload failed", studentFormPage.isPictureUploaded());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to click the submit button without filling in any data: " + e.getMessage());
        }
    }
}
