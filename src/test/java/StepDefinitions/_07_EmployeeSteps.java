package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.List;
public class _07_EmployeeSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @Given("Human Resources")
    public void humanResources(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            ln.findAndClick(listElement.get(i));

        }
    }

    @And("Employee to click")
    public void employeeToClick(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            ln.findAndClick(listElement.get(i));

        }
    }

    @And("Employee firstname or lastname")
    public void employeeFirstnameOrLastname(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        }
    }


    @And("Gender to Click")
    public void genderToClick(DataTable elements) {
        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            dc.findAndClick(listElement.get(i));

        }
    }

    @And("Employee Type Select")
    public void employeeTypeSelect() {
        dc.actionEsc();
    }








}



