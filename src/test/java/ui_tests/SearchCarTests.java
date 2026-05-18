package ui_tests;

import manager.AppManager;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests extends AppManager {
    HomePage homePage;
    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage (getDriver ());
    }
    @Test
    public void searchCarPositiveTest() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of (2026, 10, 9);
        LocalDate finalDate = LocalDate.of (2026, 11, 11);
        homePage.typeSearchForm (city, startDate, finalDate);
        homePage.clickYallaBtn ();
        Assert.assertTrue (homePage.urlContains ("results",5));
    }

    @Test
    public void searchCarNegativeTestEmptyCity() {
        String city = "";
        LocalDate startDate = LocalDate.of (2026, 10, 9);
        LocalDate finalDate = LocalDate.of (2026, 11, 11);
        homePage.typeSearchFormWOJS (city, startDate, finalDate);
        homePage.clickYallaBtn ();
        Assert.assertFalse(homePage.urlContains("results", 5));


    }

    @Test
    public void searchCarNegativeTestEmptyCityErrorValid() {
        String city = "";
        LocalDate startDate = LocalDate.of (2026, 10, 9);
        LocalDate finalDate = LocalDate.of (2026, 11, 11);
        homePage.typeSearchFormWOJS (city, startDate, finalDate);
        Assert.assertFalse(homePage.urlContains("results", 5));
        Assert.assertTrue (homePage.isTextInErrorPresent ("City is required"));
    }
    @Test
    public void searchCarPositiveTestWithCalendar() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of (2026, 10, 9);
        LocalDate finalDate = LocalDate.of (2026, 11, 11);
        homePage.typeSearchFormWithCalendar (city, startDate, finalDate);
//        homePage.clickYallaBtn ();
//        Assert.assertTrue (homePage.urlContains ("results",5));
    }

}
