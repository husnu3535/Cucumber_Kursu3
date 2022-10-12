package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _08_ApachePOISteps {
    DialogContent dc = new DialogContent();

    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        // Excel den oku ve citizenship i create et
        ArrayList<ArrayList<String>> liste = ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx"
                , "testCitizen", 3);

        for (ArrayList<String> satir : liste) {
            dc.findAndClick("createButton");
            dc.findAndSend("nameInput", satir.get(0));
            dc.findAndSend("shortName", satir.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successfully", "successfully");
        }

    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> liste = ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx"
                , "testCitizen", 1);

        for (ArrayList<String> satir : liste) {
            dc.searchAndDelete(satir.get(0));
            dc.findAndContainsText("successfully", "successfully");
        }
    }


}