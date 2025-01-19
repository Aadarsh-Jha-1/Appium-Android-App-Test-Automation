package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Function;

public class ProductsPage extends Function {
	
	AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
    	
    	super(driver); // for Functions Class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    
    // Locate the Product Page Title
    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement productPageTitle;
    
    public void getPageTitle() {
        Assert.assertTrue(productPageTitle.isDisplayed());
    }
    
    
    
    
    //Get Add to cart button  by index
    
    public WebElement getAddToCartButton(int instance) {
        String uiAutomatorSelector = String.format(
            "new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(%d)", 
            instance
        );
        return driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorSelector));
    }
    
   
   
    // Scroll To Product and add to cart
    
    public void AddProductToCart(String productName, int addToCartButtonIndex) {
    	
    	scrollTo(productName);
        
        getAddToCartButton(addToCartButtonIndex).click();
          
          
    }
    
   
    // Get added to cart text after clicking add to cart
    
    public WebElement AddedToCartMessage(int instance) {
        String uiAutomatorSelector = String.format(
            "new UiSelector().text(\"ADDED TO CART\").instance(%d)", 
            instance
        );
        return driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorSelector));
    }
    
    
    
    //No. of products added to the cart
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private WebElement cartBadgeCounter;
    
    @SuppressWarnings("deprecation")
	public String NumberOfProductsInCart() {
        return cartBadgeCounter.getAttribute("name");
    }
    
    public void clickCartBadge() {
    	cartBadgeCounter.click();
    }
    

}
