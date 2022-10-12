package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class _09_JDBCStateSteps {
    DialogContent dc=new DialogContent();
    @Then("States JDBC {string} and UI States with match")
    public void statesJDBCAndUIStatesWithMatch(String sorgu) {
        // DB den verileri liste atma işlemi
        ArrayList<ArrayList<String>>dbListe= DBUtility.getListData(sorgu);
        System.out.println(dbListe);

        // Web deki verileri list e atma işlemi
        List<WebElement>uIList=dc.ListWebElementWait(dc.listStatesName);
        for (WebElement liste : uIList )
            System.out.println("liste.getText = "+liste.getText());

        // Karşılastırma işlemi
        for (int i=0;  i < dbListe.size(); i++ )

            Assert.assertEquals(dbListe.get(i).get(1),uIList.get(i).getText());



    }
}
