package TestCase;

import Data.ReadExcel;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.userRegisteration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;




public class MyAccountTest extends Base_test{

    HomePage homeObject;
    userRegisteration registerObject ;
    LoginPage loginObject;
    MyAccountPage MyaccountObject;
    String oldPassword = "test123@";
    String newPassword = "123456";
    String firstName = "ahmed";
    String lastName = "tarek";
    String email = "test29@gmail.com";
    @Test(priority = 0,alwaysRun = true)
    public void UserCanRegisterSuccessfully () throws InterruptedException {
        homeObject = new HomePage(Base_test_driver);
        loginObject = new LoginPage(Base_test_driver);
        Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homeObject.openRegisterationPage();
        registerObject = new userRegisteration(Base_test_driver);
        registerObject.userRegisteration(firstName,lastName,email,oldPassword);
        Assert.assertEquals(registerObject.expected_successRegister(),"Your registration completed");

    }
//    @Test(priority = 2,dependsOnMethods = ("UserCanRegisterSuccessfully"))
//    public void RegisteredUserCanChangePass() throws InterruptedException {
//        MyaccountObject = new MyAccountPage(Base_test_driver);
//        registerObject.openMyAccountPage();
//        registerObject.openChangepassword();
//        MyaccountObject.ChangePassword(oldPassword,newPassword);
//
//    }
//    @Test(priority = 3)
//    public void RegisterUserCanLogout () throws InterruptedException {
//        Thread.sleep(6000);
//        registerObject.clickLogout();
//    }
    @Test(priority = 1)
    public void RegisterUserCanLogin () throws InterruptedException {
        homeObject = new HomePage(Base_test_driver);
        loginObject = new LoginPage(Base_test_driver);

        homeObject.openLoginPage();
        loginObject.UserLogin(email,oldPassword);
        Thread.sleep(6000);
        Assert.assertTrue(registerObject.expected_logoutlink().contains("Log out"));
    }
//    @Test(priority = 4)
//    public void RegisterUserCanLoginAfterPasswordChange () throws InterruptedException {
//        homeObject.openLoginPage();
//        loginObject.UserLogin(email,newPassword);
//        Thread.sleep(6000);
//        Assert.assertTrue(registerObject.expected_logoutlink().contains("Log out"));
//    }

    }


