package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends Base_page{
   public ShoppingCartPage(WebDriver base_page_driver)
   {
      super(base_page_driver);
   }

   public By checkoutButton = By.id("checkout");
   public By TCsCheckBox = By.id("termsofservice");

   public By cityTxtbox = By.id("BillingNewAddress_City");
   public By adresstxt = By.id("BillingNewAddress_Address1");
   public By postalCodetxt = By.id("BillingNewAddress_ZipPostalCode");
   public By PhoneNumbertxt = By.id("BillingNewAddress_PhoneNumber");
   public  By ContinueBtn = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");

   public By save = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
   public By confirmbtn = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
   public By confirmation = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
   public By success = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
   public By message = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
   public void ClickOnCheckout()
   {
      JavascriptExecutor java=(JavascriptExecutor)base_page_driver;
      java.executeScript("scroll(0,1000)");
      clickbutton(TCsCheckBox);
      clickbutton(checkoutButton);
   }
   public void EnterMissingDetails()
   {
      Select drpCountry = new Select(base_page_driver.findElement(By.id("BillingNewAddress_CountryId")));
      drpCountry.selectByVisibleText("Egypt");
      setTextElmentText(cityTxtbox,"Cairo");
      setTextElmentText(adresstxt,"Cairo");
      setTextElmentText(postalCodetxt,"1234");
      setTextElmentText(PhoneNumbertxt,"1234");

   }
   public void Confirmation()
   {
     clickbutton(ContinueBtn);
      clickbutton(save);
      JavascriptExecutor java=(JavascriptExecutor)base_page_driver;
      java.executeScript("scroll(0,1000)");
      clickbutton(confirmbtn);
      java.executeScript("scroll(0,1000)");
      clickbutton(confirmation);
      java.executeScript("scroll(0,1000)");
      clickbutton(success);
   }
   public String expected_successRegister()
   {
      //wait_elements(base_page_driver,10,Employee_information);
      return base_page_driver.findElement(message).getText();
   }






}
