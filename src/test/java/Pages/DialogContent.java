package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookies;

    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c74-2']>input")
    private WebElement username;

    @FindBy(css = "[type='password']")
    private WebElement password;

    @FindBy(css = "[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "(//*[text()=' Dashboard '])[1]")
    private WebElement DashBoard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement createButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;//////////////////---------------------burada kaldım delete işlemi için

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(css = "[class='mat-slide-toggle-thumb']")
    private WebElement stateExitsButton;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successfully;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']//span[1]")
    private WebElement closePencere;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.INTEGRATION_CODE']//input")
    private WebElement ıntegrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement prioarity;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastName;

    @FindBy(xpath = "(//span[text()='Gender'])[1]")
    private WebElement gender;

    @FindBy(xpath = "//span[text()=' Male ']")
    private WebElement male;

    @FindBy(xpath = "//input[@formcontrolname='employeeId']")
    private WebElement employeeID;

    @FindBy(xpath = "(//span[text()='Employee Type'])[1]")
    private WebElement employeeType;

    @FindBy(xpath = "(//span[text()=' Other '])[1]")
    private WebElement other;

    @FindBy(xpath = "//tbody[@role='rowgroup']//td[2]")
    public List<WebElement> listStatesName;


    WebElement myElement;

    public void findAndSend(String strElement, String value) { // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement) {
            case "username":myElement = username;break;
            case "password":myElement = password;break;
            case "nameInput":myElement = nameInput;break;
            case "codeInput":myElement = codeInput;break;
            case "shortName":myElement = shortName;break;
            case "searchInput":myElement = searchInput;break;
            case "ıntegrationCode":myElement = ıntegrationCode;break;
            case "prioarity":myElement = prioarity;break;
            case "firtsName":myElement = firstName;break;
            case "lastName":myElement = lastName;break;
            case "employeeID":myElement = employeeID;break;

        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) { // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement) {
            case "acceptClick":myElement = acceptCookies;break;
            case "loginButton":myElement = loginButton;break;
            case "createButton":myElement = createButton;break;
            case "saveButton":myElement = saveButton;break;
            case "closePencere":myElement = closePencere;break;
            case "searchButton":myElement = searchButton;break;
            case "deleteButton":myElement = deleteButton;break;
            case "deleteDialogBtn":myElement = deleteDialogBtn;break;
            case "gender":myElement = gender;break;
            case "male":myElement = male;break;

        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) { // 2.AŞAMA
        // Burda String isimden Webelemente ulaşıcam
        switch (strElement) {
            case "Dashboard": myElement = DashBoard;break;
            case "successfully":myElement = successfully;break;
            case "alreadyExist":myElement = alreadyExist;break;

        }
        verifyContainsText(myElement, text);
    }

    public void searchAndDelete(String searchText) {
        findAndSend("searchInput", searchText);// Arama kutucuğuna kelimeyi yaz
        findAndClick("searchButton"); // Arama butonuna bas

        //   waitUntilLoading();// -> Bekleme ile ilgili güzel bir yol -----> harika
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));

        findAndClick("deleteButton");// Silme butonuna bas
        findAndClick("deleteDialogBtn");  // Dialog daki silme butonuna bas

    }
    public void actionEsc() {
        Actions aksiyon = new Actions(GWD.getDriver());
        aksiyon.moveToElement(employeeType).click().build().perform();
        aksiyon.moveToElement(other).click().build().perform();
        aksiyon.moveToElement(other).keyDown(Keys.ESCAPE).build().perform();
    }
}
