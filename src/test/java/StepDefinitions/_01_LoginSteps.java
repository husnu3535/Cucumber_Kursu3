package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {
    DialogContent dc=new DialogContent();

    @Given("Navigate to basqar")
    public void navigateToBasqar() {
        GWD.getDriver().get("https://demo.mersys.io/");
        GWD.getDriver().manage().window().maximize();
       // richfield.edu -> Id
       // Richfield2020! -> pw

    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

       // dc.username.sendKeys("richfield.edu");
       // dc.password.sendKeys("Richfield2020!");
       // dc.login.click();
        // 1.AŞAMA
        dc.findAndClick("acceptClick");
        dc.findAndSend("username","richfield.edu");
        dc.findAndSend("password","Richfield2020!");
        dc.findAndClick("loginButton");

    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {
    //    dc.waitUntilVisible(dc.dashBoard);
    //    Assert.assertTrue(dc.dashBoard.getText().contains("Dashboard"));
            dc.findAndContainsText("Dashboard","Dashboard");

    }
}
