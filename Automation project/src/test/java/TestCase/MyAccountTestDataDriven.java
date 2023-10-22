package TestCase;

import Data.ReadExcel;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.userRegisteration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class MyAccountTestDataDriven extends Base_test{

    HomePage homeObject;
    userRegisteration registerObject ;
    LoginPage loginObject;
    @Test(dataProvider = "userdata")
    public void AccountRegisterDataProviderExcel(String firstName,String lastName,String email,String password) {
        homeObject = new HomePage(Base_test_driver);
        loginObject = new LoginPage(Base_test_driver);
        Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homeObject.openRegisterationPage();
        registerObject = new userRegisteration(Base_test_driver);
        registerObject.userRegisteration(firstName, lastName, email, password);
        Assert.assertEquals(registerObject.expected_successRegister(), "Your registration completed");
        loginObject.UserLogin(email, password);
        Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

        @Test(dataProvider = "userdata")
    public void RegisterUserCanLogin (String firstName,String lastName,String email,String password) throws InterruptedException {
                    homeObject = new HomePage(Base_test_driver);
        loginObject = new LoginPage(Base_test_driver);
        homeObject.openLoginPage();
        loginObject.UserLogin(email,password);
       Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
registerObject = new userRegisteration(Base_test_driver);
        registerObject.clickLogout();
    }
    @DataProvider(name = "userdata")
    public Object[][] userRegisteredData() throws IOException {
        //get data from Excel class
        ReadExcel excelObject = new ReadExcel();
        return excelObject.getexcelData();
    }
}
