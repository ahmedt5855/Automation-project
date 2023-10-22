package TestCase;

import Pages.Base_page;
import Utilities.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base_test {
    public static WebDriver Base_test_driver;



    @BeforeTest
    @Parameters("browser")
    public void startDriver(String browserName) throws InterruptedException {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            Base_test_driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            Base_test_driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            Base_test_driver = new InternetExplorerDriver();
        }
        Base_test_driver.manage().window().maximize();
        Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Base_test_driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @AfterTest
    public void stopDriver() {
        Base_test_driver.quit();
    }

//    take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking ScreenShot");
            Helper.captureScreeshot(Base_test_driver, result.getName());
        }
    }
}