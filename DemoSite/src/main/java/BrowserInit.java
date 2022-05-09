import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserInit {
    public static WebDriver driver;

    /**
     * Use this method only after Launch
     */
    public static WebDriver getDriver() {
        return driver;
    }

    public static void Launch(String baseURL) {
        try {
            //setup the chromedriver using WebDriverManager
            WebDriverManager.chromedriver().setup();
            //Create driver object for Chrome
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();
        } catch (Exception ex) {
        }
    }

   // @AfterMethod
    public static void Close() {
        try {
            if (driver != null) {
             //   driver.quit();
            }
        } catch (Exception ex) {
        }
    }

}
