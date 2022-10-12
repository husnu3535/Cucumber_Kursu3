package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{
        public FormContent() {
            PageFactory.initElements(GWD.getDriver(),this);
        }

    @FindBy (xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement AcademicPeriod;

    @FindBy (xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement AcademicYear;

    @FindBy (xpath = "(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;

    @FindBy (xpath = "(//span[@class='mat-option-text'])[5]")
    private WebElement gradeNumber;


    WebElement myElement;
    public void findAndSend(String strElement,String value){ // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement){

        }
        sendKeysFunction(myElement,value);
    }
    public void findAndClick(String strElement){ // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement){
            case "AcademicPeriod":myElement=AcademicPeriod;break;
            case "AcademicYear":myElement=AcademicYear;break;
            case "gradeLevel":myElement=gradeLevel;break;
            case "gradeNumber":myElement=gradeNumber;break;

        }
        clickFunction(myElement);
    }
    public void findAndContainsText(String strElement,String text){ // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement){

        }
        verifyContainsText(myElement,text);
    }

    public void searchAndDelete(String searchText){ // 2.AŞAMA
        findAndSend("searchInput",searchText);// Arama kutucuğuna kelimeyi yaz
        findAndClick("searchButton"); // Arama butonuna bas
        waitUntilLoading();// -> Bekleme ile ilgili güzel bir yol
        findAndClick("deleteButton");// Silme butonuna bas
        findAndClick("deleteDialogBtn");  // Dialog daki silme butonuna bas

    }
}
