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
    
 
    
    
    // get E-mails checkbox
	
 	@AndroidFindBy(className = "android.widget.CheckBox")
     private WebElement subscribeEmailsCheckbox;
 	
 	public void clickSubscribeEmailsCheckbox() {
 		subscribeEmailsCheckbox.click();
 	}
 	
 	public String isCheckBoxChecked() {
 		
 		return subscribeEmailsCheckbox.getAttribute("checked");
 	}
    
    
    // Terms and condition
    
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndConditionLocator;
    
	public void getTermsAndConditions() {
    	
    	longPressOn(termsAndConditionLocator);
       
    }
	
	//T&C Page Title
	 
	@AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement termsAndConditionAlertTitle;
	
	public String getTermsAndConditionsAlertTitle() {
		return termsAndConditionAlertTitle.getAttribute("name");
	}
    
	
	//close T&C Page
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closePage;
	
	public void closeTermsAndConditionAlert() {
		closePage.click();
	}
	
	
	
	
	//Submit/Proceed Button
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	public void clickProceedBtn() {
		
		proceedButton.click();
	}
	
	
}
