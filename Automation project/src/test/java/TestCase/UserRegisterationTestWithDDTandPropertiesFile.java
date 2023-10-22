package TestCase;
import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.userRegisteration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserRegisterationTestWithDDTandPropertiesFile extends Base_test{
    HomePage homeObject;
    userRegisteration registerObject ;
    LoginPage loginObject;
    String firstname = LoadProperties.userdata.getProperty("firstname");
    String lastname = LoadProperties.userdata.getProperty("lastname");
    String email = LoadProperties.userdata.getProperty("email");
    String password = LoadProperties.userdata.getProperty("password");


    @Test(priority = 1,alwaysRun = true)
    public void UserCanRegisterSuccessfully () throws InterruptedException {
         homeObject = new HomePage(Base_test_driver);
        homeObject.openRegisterationPage();
        registerObject = new userRegisteration(Base_test_driver);
        registerObject.userRegisteration(firstname,lastname,email,password);
        Assert.assertEquals(registerObject.expected_successRegister(),"Your registration completed");
        homeObject.openLoginPage();
        loginObject = new LoginPage(Base_test_driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(registerObject.expected_logoutlink().contains("Log out"));
        Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.clickLogout();





        //Thread.sleep(6000);


    }
}
