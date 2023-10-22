package TestCase;

import Pages.HomePage;
import Pages.Productpage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class ProductHoverMenuTest extends Base_test{



@Test(priority = 0)
    public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException {
    HomePage homeObject = new HomePage(Base_test_driver);
homeObject.selectNotebookMenu();
Assert.assertTrue(Base_test_driver.getCurrentUrl().contains("notebooks"));

}
@Test (priority = 1 , dependsOnMethods = ("UserCanSelectSubCategoryFromMainMenu"))
    public void UserCanAddItemToCart() throws InterruptedException {
    Productpage productObject = new Productpage(Base_test_driver);
    Base_test_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

    productObject.AddToCart();

    productObject.OpenShoppingCart();
    ShoppingCartPage shoppingObject = new ShoppingCartPage(Base_test_driver);
    shoppingObject.ClickOnCheckout();
    shoppingObject.EnterMissingDetails();
    shoppingObject.Confirmation();
    Assert.assertEquals(shoppingObject.expected_successRegister(),"Your order has been successfully processed!");
    Thread.sleep(2000);
}






}
