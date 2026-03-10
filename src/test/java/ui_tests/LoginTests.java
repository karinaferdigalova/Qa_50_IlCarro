package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUpPage;
import pages.RegistrationPage;

public class LoginTests extends AppManager {

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
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("Logged in success"));

    }

}
