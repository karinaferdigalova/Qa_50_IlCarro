package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PopUpPage;
import pages.RegistrationPage;

import static utils.UserFactory.*;

import java.util.Random;

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;


    @BeforeMethod
    public void goToHomePage() {
        new HomePage (getDriver ()).clickBtnSignUp ();
        registrationPage = new RegistrationPage (getDriver ());
    }

    @Test
    public void registrationWithFakerPositiveTest() {
        User user = positiveUser ();
        registrationPage.typeRegForm (user);
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("You are logged in success"));
        registrationPage.clickBtnOk ();


    }

    @Test
    public void registrationPositive() {
        int i = new Random ().nextInt (1000);
        User user = User.builder ()
                .firstName ("Sara")
                .lastName ("Mit")
                .email ("saramit" + i + "@gmail.com")
                .password ("Saramit32!")
                .build ();

        registrationPage.typeRegForm (user);
//        Assert.assertTrue (registrationPage.ifRegSuccessMessagePresent
//                ("You are logged in success"));
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("You are logged in success"));
        registrationPage.clickBtnOk ();

    }

}
