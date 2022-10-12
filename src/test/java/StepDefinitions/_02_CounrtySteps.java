package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CounrtySteps {
    DialogContent dc=new DialogContent();
    LeftNav ln=new LeftNav();

    @And("Navigate to country page")
    public void navigateToCountryPage() {

        ln.findAndClick("setup");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");

    }

    @When("Create a country")
    public void createACountry() {
        String randomGenName= RandomStringUtils.randomAlphabetic(8);
        String randomGenCode= RandomStringUtils.randomNumeric(4);

        dc.findAndClick("createButton");
        dc.findAndSend("nameInput",randomGenName);
        dc.findAndSend("codeInput",randomGenCode);
        dc.findAndClick("stateExitsbutton");
        dc.findAndClick("saveButton");


    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successfully","successfully");


    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.findAndClick("createButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndClick("stateExitsbutton");
        dc.findAndClick("saveButton");





    }
}
