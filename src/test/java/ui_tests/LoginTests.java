package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

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

}
