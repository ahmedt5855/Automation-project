package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Base_page {
    public static WebDriver base_page_driver;

    Base_page(WebDriver driver)
    {
         base_page_driver = driver;
    }


protected static void clickbutton(By button)
{
    base_page_driver.findElement(button).click();
}
protected static void setTextElmentText (By textElement , String value)
{
    base_page_driver.findElement(textElement).sendKeys(value);

}
}
