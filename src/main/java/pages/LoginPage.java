package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver (driver);
        PageFactory.initElements (new AjaxElementLocatorFactory (driver,
                10), this);
    }

    @FindBy (id="email")
    WebElement inputEmail;
    @FindBy (id="password")
    WebElement inputPassword;
    @FindBy (xpath="//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[text()='Logged in success']")
    WebElement popUpSuccessLogin;

    public void submitLoginForm(User user) {
        inputEmail.sendKeys (user.getEmail ());
        inputPassword.sendKeys (user.getPassword ());
        pause (3);
        btnYalla.click ();
    }
    public void btnYallaClick(){
        btnYalla.click ();
    }
    public boolean isLoggenDisplayed(){
        return popUpSuccessLogin.isDisplayed ();
    }
}
