package AppHooks;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order = 0)
    public void launchBrowser() {
        String browserName = "chrome"; 
        
        // FIX: You must initialize the object before calling init_driver()
        driverFactory = new DriverFactory(); 
        
        // Now driverFactory is NOT null, and we can call its methods
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}