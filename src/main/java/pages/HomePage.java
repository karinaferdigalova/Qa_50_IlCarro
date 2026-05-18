package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.LocalDate;

import static utils.PropertiesReader.*;

public class HomePage extends BasePage {
    @FindBy (xpath="//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy (xpath="//a[text()='Sign up']")
    WebElement btnSignUp;
    @FindBy (id="city")
    WebElement fieldCity;
    @FindBy (id="dates")
    WebElement fieldData;
    @FindBy (xpath="//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy (xpath="//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement btnYearCalendar;

    public HomePage(WebDriver driver) {
        setDriver (driver);
        // driver.get ("https://ilcarro.web.app/search");
        driver.get (getProperty ("base.properties", "baseUrl"));
        PageFactory.initElements (new AjaxElementLocatorFactory
                (driver, 10), this);
    }
    public void typeSearchFormWithCalendar
            (String city,LocalDate startDate,LocalDate finalDay){
        fieldCity.sendKeys (city);
        fieldData.click ();
        typeCalendar (finalDay);
    }
    public void typeCalendar(LocalDate date){
        btnYearCalendar.click ();
        ////td[@aria-label="2027"]
        String year = Integer.toString (date.getYear ());
        WebElement btnYear = driver.findElement (By.xpath
                ("//td[@aria-label='"+year+"']"));
        btnYear.click ();
    }

    public void clickBtnSignUp() {
        btnSignUp.click ();
    }

    public void clickBtnLogin() {
        btnLogin.click ();
    }

    public void typeSearchForm(String city, LocalDate startDate, LocalDate finalDate) {
        fieldCity.sendKeys (city);
        String dates = startDate.getMonthValue () + "/" + startDate.getDayOfMonth ()
                + "/" + startDate.getYear () + " - " + finalDate.getMonthValue () + "/"
                + finalDate.getDayOfMonth () + "/" + finalDate.getYear ();
        fieldData.sendKeys (dates);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("document.querySelector(\"button[type='submit']\")" +
                ".removeAttribute(\"disabled\")");
        //clickWait (btnSubmit, 3);

        //document.querySelector("button[type='submit']").removeAttribute("disabled")
        // - через js в консоле на странице где поиск веб элементов
        // ( потому что кнопка была отключена)
    }
    public void typeSearchFormWOJS(String city, LocalDate startDate, LocalDate finalDate) {
        fieldCity.sendKeys (city);
        String dates = startDate.getMonthValue () + "/" + startDate.getDayOfMonth ()
                + "/" + startDate.getYear () + " - " + finalDate.getMonthValue () + "/"
                + finalDate.getDayOfMonth () + "/" + finalDate.getYear ();
        fieldData.sendKeys (dates);
        btnSubmit.click ();
    }
    public void clickYallaBtn(){
        btnYalla.click ();

    }
}
