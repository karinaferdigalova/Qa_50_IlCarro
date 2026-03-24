package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;

    }

    @FindBy (xpath="//div[@class='error']")
    List<WebElement> errorsList;

    public boolean isTextInErrorPresent(String text) {
        if (errorsList == null || errorsList.isEmpty ())
            return false;
        for (WebElement element : errorsList) {
            if (element.getText ().contains (text))
                return true;
        }
        return false;
    }

    public void pause(int time) {
        try {
            Thread.sleep (time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
    }

    public boolean isMessagePresent(WebElement element, String text) {
        return element.getText ().contains (text);
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed ();
    }

    public boolean isTextInElementPresentWithWait(WebElement element, String text) {
        return new WebDriverWait (driver, Duration.ofSeconds (10))
                .until (ExpectedConditions.textToBePresentInElement (element, text));

    }

    public void triggerBlur(WebElement element) {
        new Actions (driver)
                .moveToElement (element)
                .click ()
                .sendKeys (Keys.TAB)
                .perform ();
    }
}

