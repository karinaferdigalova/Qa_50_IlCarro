package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.PopUpPage;
import pages.RegistrationPage;

import static utils.UserFactory.*;

import java.util.Random;

public class RegistrationTests extends AppManager {
    RegistrationPage registrationPage;
    SoftAssert softAssert = new SoftAssert ();


    @BeforeMethod
    public void goToHomePage() {
        new HomePage (getDriver ()).clickBtnSignUp ();
        registrationPage = new RegistrationPage (getDriver ());
    }

    @Test
    public void registrationWithFakerPositiveTest() {
        User user = positiveUser ();
        registrationPage.typeRegForm (user);
        registrationPage.clickYallaBtn ();
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
        registrationPage.clickYallaBtn ();
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("You are logged in success"));
        registrationPage.clickBtnOk ();

    }

    @Test
    public void registrationNegativeTestsUserExist() {
        User user = User.builder ()
                .firstName ("Sara")
                .lastName ("Mit")
                .email ("karina29@gmail.com")
                .password ("karinA29!")
                .build ();
        registrationPage.typeRegForm (user);
        registrationPage.clickYallaBtn ();
        Assert.assertTrue (new PopUpPage (getDriver ()).isTextInPopUpPresent
                ("User already exists"));
        registrationPage.clickBtnOk ();
    }
    @Test
    public void registrationNegativeTestsEmptyAll() {
        User user = User.builder ()
                .firstName ("")
                .lastName ("")
                .email ("")
                .password ("")
                .build ();
        registrationPage.typeRegForm (user);
        registrationPage.blurPasswordField ();
        Assert.assertTrue (registrationPage.YallaIsDisabled ());
        softAssert.assertTrue(registrationPage.isTextInErrorPresent ("Name is required"),
                "message for empty field name");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent ("Last name is required"),
                "message for empty field last name");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent ("Email is required"),
                "message for empty field email");
        softAssert.assertTrue(registrationPage.isTextInErrorPresent ("Password is required"),
                "message for empty field password");
        softAssert.assertAll ();


    }


}
