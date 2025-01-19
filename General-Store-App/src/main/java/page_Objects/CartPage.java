package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Function;

public class CartPage extends Function{
	
	AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
    	
    	super(driver); // for Functions Class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    
    // Locate the Cart Page Title
    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement cartPageTitle;
    
    @SuppressWarnings("deprecation")
	public String getCartPageTitle() {
       return cartPageTitle.getAttribute("name");
    }
    
    
    //Locate Product
    
    public WebElement productLocator(String productName) {
    	
    	return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + productName + "\")"));   
    }

    
    
    // get product price 
    
    public float getProductPrice(int index) {
    	
    	String priceString = driver.findElements(AppiumBy.androidUIAutomator(
			    "new UiSelector().resourceId(\"com.androidsample.generalstore:id/productPrice\")"
			)).get(index).getAttribute("name");
			
			 // Remove the '$' symbol and convert to float
	        return Float.parseFloat(priceString.replace("$", "").trim());
    }
    
    
    // Total Price Locator
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPriceLocator;
    
    public float getTotalPrice() {
    	
    	String totalPriceString = totalPriceLocator.getAttribute("name");
    	
    	 // Remove the '$' symbol and convert to float
        return Float.parseFloat(totalPriceString.replace("$", "").trim());
    }
}
