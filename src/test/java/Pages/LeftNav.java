package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath ="(//span[text()='Setup'])[1]")
    private WebElement setup;

    @FindBy(xpath ="(//span[text()='Parameters'])[1]")
    private WebElement parameters;

    @FindBy(xpath ="(//span[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath ="//*[text()='Citizenships']")
    private WebElement citizenship;

    @FindBy(xpath ="//a[@href='/nationality/list']//span")
    private WebElement nationality;

    @FindBy(xpath ="//a[@href='/fee-types/list']//span")
    private WebElement fees;

    @FindBy(xpath ="//a[@class='nav-link ng-tns-c249-12 ng-star-inserted']//span")
    private WebElement EntranceExams;

    @FindBy(xpath ="(//span[text()='Setup'])[2]")
    private WebElement setup2;

    @FindBy(xpath ="//a[@href='/exam/list']//span")
    private WebElement EntranceExams2;

    @FindBy(xpath ="//span[text()='Human Resources']")
    private WebElement HumanSrc;

    @FindBy(xpath =" //span[text()='Employees']")
    private WebElement employee;

    @FindBy(xpath = "(//span[contains(text(),'States')])[1]")
    private WebElement states;










    WebElement myElements;

    public void findAndClick(String strElement){ // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement){
            case "setup": myElements=setup;break;
            case "parameters":myElements=parameters;break;
            case "countries":myElements =countries;break;
            case "citizenShip":myElements=citizenship;break;
            case "nationality":myElements=nationality;break;
            case "fees":myElements=fees;break;
            case "EntranceExams":myElements=EntranceExams;break;
            case "setup2":myElements=setup2;break;
            case "EntranceExams2":myElements=EntranceExams2;break;
            case "humanSrc":myElements=HumanSrc;break;
            case "employee":myElements=employee;break;
            case "states":myElements=states;break;


        }
            clickFunction(myElements);
    }







}