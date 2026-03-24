package pages;

import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    @FindBy (id="name")
    WebElement inpFirstName;
    @FindBy (id="lastName")
    WebElement inpLastName;
    @FindBy (id="email")
    WebElement inpEmail;
    @FindBy (id="password")
    WebElement inpPassword;
    @FindBy (xpath="//label[@class='checkbox-label terms-label']")
    WebElement checkBoxTermsOfUse;
    @FindBy (xpath="//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy (xpath="//h2[text()='You are logged in success']")
    WebElement successRegMessage;
    @FindBy (xpath="//button[@class='positive-button ng-star-inserted']")
    WebElement btnOk;

    public RegistrationPage(WebDriver driver) {
        setDriver (driver);
        PageFactory.initElements (new AjaxElementLocatorFactory (driver, 10), this);
    }

    public void typeRegForm(User user) {
        inpFirstName.sendKeys (user.getFirstName ());
        inpLastName.sendKeys (user.getLastName ());
        inpEmail.sendKeys (user.getEmail ());
        inpPassword.sendKeys (user.getPassword ());
        clickCheckBox ();

    }

    public void clickCheckBox() {
        WebElement checkBox = driver.findElement (By.id ("terms-of-use"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("arguments[0].click();", checkBox);

    }

    public boolean YallaIsDisabled() {
        return btnYalla.getAttribute ("disabled") != null;
    }

    public void clickBtnOk() {
        btnOk.click ();

    }
    public void clickYallaBtn(){
        btnYalla.click ();

    }
    public boolean ifRegSuccessMessagePresent(String text) {
        return isMessagePresent (successRegMessage, text);

    }
    public void blurPasswordField(){
        triggerBlur (inpPassword);
    }
}
