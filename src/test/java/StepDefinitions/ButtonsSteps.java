package StepDefinitions;

import PageObjects.ButtonsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static StepDefinitions.Hooks.getDriver;

public class ButtonsSteps {

    private ButtonsPage buttonsPage = new ButtonsPage(getDriver());

    @Given("The user is on the buttons page")
    public void userIsOnButtonsPage() {
        buttonsPage.navigateToButtonsPage();
    }

    @When("The user clicks the Click button")
    public void userClicksClickButton() {
        try {
            buttonsPage.performSingleClick();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to perform single click: " + e.getMessage());
        }
    }

    @When("The user right-clicks the Right Click button")
    public void userRightClicksRightClickButton() {
        try {
            buttonsPage.performRightClick();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to perform right-click: " + e.getMessage());
        }
    }

    @When("The user double-clicks the Double Click button")
    public void userDoubleClicksDoubleClickButton() {
        try {
            buttonsPage.performDoubleClick();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to perform double click: " + e.getMessage());
        }
    }

    @Then("The output message for {string} should be {string}")
    public void outputMessageShouldBe(String action, String expectedMessage) {
        try {
            String actualMessage = buttonsPage.getOutputMessage(action);
            Assert.assertEquals("Output message mismatch for action: " + action, expectedMessage, actualMessage);
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e; // Re-throw to ensure the test fails and shows the error
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to verify output message for action: " + action + ". Error: " + e.getMessage());
        }
    }
}
