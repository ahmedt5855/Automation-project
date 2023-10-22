package TestCase;
import Pages.Base_page;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.userRegisteration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserRegisterationTest extends Base_test{
    HomePage homeObject;
    userRegisteration registerObject ;
    LoginPage loginObject;
@DataProvider(name = "Test-data")
   public static Object[][]UserData()
{
    return new Object[][]{

    {"Moataz", "Nabil", "testxox@gmail.com", "1234556"}, {"Ahmed","Tarek","testuser1255@gmail.com","789456"}
};
}
    @Test(priority = 1,alwaysRun = true,dataProvider = "Test-data")
    public void UserCanRegisterSuccessfully (String fname,String lname , String email, String password) throws InterruptedException {
         homeObject = new HomePage(Base_test_driver);
        homeObject.openRegisterationPage();
        registerObject = new userRegisteration(Base_test_driver);
        registerObject.userRegisteration(fname,lname,email,password);
        Assert.assertEquals(registerObject.expected_successRegister(),"Your registration completed");
        registerObject.clickLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(Base_test_driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(registerObject.expected_logoutlink().contains("Log out"));
        Base_test_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        registerObject.clickLogout();





        //Thread.sleep(6000);


    }
}
