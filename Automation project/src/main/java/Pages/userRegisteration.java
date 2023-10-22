package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class userRegisteration extends Base_page{
    public userRegisteration(WebDriver base_page_driver) {
        super(base_page_driver);
    }
    public By genderbtn =By.id("gender-male");
    public By FirstName =By.id("FirstName");
    public By LastName =By.id("LastName");
    public By Email =By.id("Email");
    public By Password =By.id("Password");
    public By ConfirmPassword =By.id("ConfirmPassword");
    public By registerbtn =By.id("register-button");
    public By successRegister = By.cssSelector("div.result");
    public By LogoutLink = By.linkText("Log out");
    public By MyaccountLink = By.partialLinkText("My account");
    public By ChangePassword = By.partialLinkText("Change password");
    public void userRegisteration(String firstname , String lastname , String email , String pass)
    {

        clickbutton(genderbtn);
        setTextElmentText(FirstName,firstname);
        setTextElmentText(LastName,lastname);
        setTextElmentText(Email,email);
        setTextElmentText(Password,pass);
        setTextElmentText(ConfirmPassword,pass);
        clickbutton(registerbtn);
    }
    public String expected_successRegister()
    {
        //wait_elements(base_page_driver,10,Employee_information);
        return base_page_driver.findElement(successRegister).getText();
    }
    public void clickLogout()
    {
        WebDriverWait wait=new WebDriverWait(base_page_driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LogoutLink));
        clickbutton(LogoutLink);
    }
    public String expected_logoutlink()
    {
        WebDriverWait wait=new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutLink));
        return base_page_driver.findElement(LogoutLink).getText();
    }
    public void openMyAccountPage()
    {
        clickbutton(MyaccountLink);
    }
    public void openChangepassword()
    {
        clickbutton(ChangePassword);
    }
}
