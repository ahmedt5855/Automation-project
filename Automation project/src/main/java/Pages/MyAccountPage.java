package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends Base_page{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public By changepasswordLink = By.linkText("Change password");
    public By oldpasswordtxt = By.id("OldPassword");
    public By newpasswordLink = By.id("NewPassword");
    public By confirmpasswordLink = By.id("ConfirmNewPassword");
    public By ChangePassBtn = By.className("change-password-button");
    public By resultLBL = By.cssSelector("div.result");
    public By closenotify = By.className("close");
    public void ChangePassword(String oldpassword , String newpassword) throws InterruptedException {
        setTextElmentText(oldpasswordtxt,oldpassword);
        setTextElmentText(newpasswordLink,newpassword);
        setTextElmentText(confirmpasswordLink,newpassword);
        clickbutton(ChangePassBtn);
        clickbutton(closenotify);
    }
    public String expected_passchanged()
    {
        WebDriverWait wait=new WebDriverWait(base_page_driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultLBL));
        return base_page_driver.findElement(resultLBL).getText();
    }
}
