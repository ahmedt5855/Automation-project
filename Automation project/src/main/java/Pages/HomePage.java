package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends Base_page{
    public HomePage(WebDriver base_page_driver) {
        super(base_page_driver);

    }
    public By registerLink = By.linkText("Register");
    public By loginLink= By.linkText("Log in");
    WebElement Computer = base_page_driver.findElement(By.xpath("//a[@href='/computers']"));
   WebElement Notebook = base_page_driver.findElement(By.xpath("//a[@href=\"/notebooks\"]"));
    Actions action = new Actions(base_page_driver);
    public void openRegisterationPage()  {

        clickbutton(registerLink);
    }
    public void openLoginPage()
    {
        clickbutton(loginLink);
    }
    public void selectNotebookMenu()
    {
            base_page_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        action.moveToElement(Computer).moveToElement(Notebook).click().build().perform();
    }
}

