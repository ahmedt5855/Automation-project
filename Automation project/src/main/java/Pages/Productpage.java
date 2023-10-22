package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Productpage extends Base_page {
    public Productpage(WebDriver base_page_driver)
    {
        super(base_page_driver);
    }
    public By addToCartFirstProduct = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]");
    public By shoppingCartButton = By.linkText("Shopping cart");
    public  By AddItemToCartInside = By.xpath("//*[@id=\"add-to-cart-button-4\"]");
    public void AddToCart() throws InterruptedException {

        JavascriptExecutor java=(JavascriptExecutor)base_page_driver;
        java.executeScript("scroll(0,500)");
        clickbutton(addToCartFirstProduct);

        java.executeScript("scroll(0,500)");
        clickbutton(AddItemToCartInside);
    }

    public void OpenShoppingCart()
    {
      clickbutton(shoppingCartButton);
    }

}
