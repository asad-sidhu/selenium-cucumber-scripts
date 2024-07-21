package StepDefinitions;

import PageObjects.RadioButtonPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;

import static StepDefinitions.Hooks.getDriver;

public class RadioButtonSteps {

    private RadioButtonPage radioButtonPage = new RadioButtonPage(getDriver());

    @Given("The user is on the radio button page")
    public void userIsOnRadioButtonPage() {
        try {
            radioButtonPage.navigateToRadioButtonPage();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to navigate to radio button page: " + e.getMessage());
        }
    }

    @Then("The user should see the radio buttons {string}, {string}, and {string}")
    public void userShouldSeeTheRadioButtons(String option1, String option2, String option3) {
        try {
            Assert.assertTrue("Radio button '" + option1 + "' is not displayed", radioButtonPage.isRadioButtonDisplayed(option1));
            Assert.assertTrue("Radio button '" + option2 + "' is not displayed", radioButtonPage.isRadioButtonDisplayed(option2));
            Assert.assertTrue("Radio button '" + option3 + "' is not displayed", radioButtonPage.isRadioButtonDisplayed(option3));
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify radio buttons visibility: " + e.getMessage());
        }
    }

    @And("The {string} radio button should be disabled")
    public void radioButtonShouldBeDisabled(String option) {
        try {
            Assert.assertFalse("Radio button '" + option + "' is not disabled", radioButtonPage.isRadioButtonEnabled(option));
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify if radio button is disabled: " + e.getMessage());
        }
    }

    @When("The user selects the {string} radio button")
    public void userSelectsRadioButton(String option) {
        try {
            radioButtonPage.selectRadioButton(option);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to select radio button '" + option + "': " + e.getMessage());
        }
    }

    @Then("The output should state {string}")
    public void outputShouldState(String expectedMessage) {
        try {
            Assert.assertEquals("Output message mismatch!", expectedMessage, radioButtonPage.getOutputMessage());
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify output message: " + e.getMessage());
        }
    }
}
