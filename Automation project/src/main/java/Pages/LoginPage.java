package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base_page{
    public LoginPage(WebDriver base_page_driver) {
        super(base_page_driver);
    }

    public By Emailtxt = By.id("Email");
    public By passtxt = By.id("Password");
    public By loginbtn = By.className("login-button");
    public void UserLogin(String Email , String Password)
    {
        setTextElmentText(Emailtxt,Email);
        setTextElmentText(passtxt,Password);
        clickbutton(loginbtn);
    }
}
