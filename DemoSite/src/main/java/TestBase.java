
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.Map;

public class TestBase {

    public static DataProviderUtility dpUtil = null;
    public static Map<String, String> map = null;

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

    @AfterMethod
    public static void Close() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ex) {
        }
    }

    @BeforeTest
    public void setup() {
        dpUtil = new DataProviderUtility();
    }

    @BeforeMethod
    protected void setupMethod(Method method) {
        String testName = method.getName();
        map = dpUtil.readMap(testName);
    }

    @AfterMethod
    protected void methodTearDown() {
        map = null;
    }

    @AfterTest
    public void tearDown() {
        map = null;
    }

}
