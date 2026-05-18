

package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AppManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    public final static Logger logger = LoggerFactory.getLogger (AppManager.class);


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

    }

    @AfterMethod ()
    public void tearDown() {
        if (driver != null) {
            driver.quit ();
        }
    }
}
//(enabled = false)