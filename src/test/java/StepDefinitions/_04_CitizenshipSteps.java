package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    DialogContent dc=new DialogContent();
    LeftNav ln=new LeftNav();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setup");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenShip");

    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.findAndClick("createButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("shortName",shortName); // bu locaterdan bulunacak
        dc.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already exists");

    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dc.findAndClick("closePencere");

    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.searchAndDelete(arananKelime);





    }
}
