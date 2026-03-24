package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUpPage;
import pages.RegistrationPage;

public class LoginTests extends AppManager {
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert ();


    @BeforeMethod
    public void goToHomePage() {
        new HomePage (getDriver ()).clickBtnLogin ();
    }


    @Test
    public void loginPositiveTest() {
        User user = User.builder ()
                .email ("karina29@gmail.com")
                .password ("karinA29!")
                .build ();
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.submitLoginForm (user);
        loginPage.clickYalla ();
        Assert.assertTrue (loginPage.isLoggenDisplayed ());
    }

    @Test
    public void loginPositiveTestPopUp() {
        User user = User.builder ()
                .email ("karina29@gmail.com")
                .password ("karinA29!")
                .build ();
        HomePage homePage = new HomePage (getDriver ());
        homePage.clickBtnLogin ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.submitLoginForm (user);
        loginPage.clickYalla ();
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("Logged in success"));

    }

    @Test
    public void loginNegativeTestsWrongPassword() {
        User user = User.builder ()
                .email ("karina29@gmail.com")
                .password ("k")
                .build ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.submitLoginForm (user);
        loginPage.clickYalla ();
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("Login or Password incorrect"));

    }

//    @Test
//    public void loginNegativeTestsEmptyPassword() {
//        User user = User.builder ()
//                .email ("karina29@gmail.com")
//                .password ("")
//                .build ();
//        LoginPage loginPage = new LoginPage (getDriver ());
//        loginPage.submitLoginForm (user);
//        Assert.assertTrue (loginPage.isTextErrorsPresent (
//                "Password is required"));
//    }

    @Test
    public void loginNegativeTestsWrongEmail() {
        User user = User.builder ()
                .email ("hjg")
                .password ("karinA29!")
                .build ();
        LoginPage loginPage = new LoginPage (getDriver ());
        loginPage.submitLoginForm (user);
        Assert.assertTrue (loginPage.isTextInErrorPresent ("It'snot look like email"));
    }
}
