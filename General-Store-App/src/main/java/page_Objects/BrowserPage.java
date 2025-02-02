package page_Objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Function;

public class BrowserPage extends Function{
	
	AndroidDriver driver;

    public BrowserPage(AndroidDriver driver) {
    	
    	super(driver); // for Functions Class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    
    // Switch to browser context :
    
    public void SwitchToWebView() {
    
    switchContextTo("WEBVIEW_com.androidsample.generalstore"); 
    
    }
    
    public void SwitchToNativeApp() {
        
        switchContextTo("NATIVE_APP"); 
        
        }
    
    
    //Google search locator
    @FindBy(name = "q")  
    private WebElement searchBox;
    
    
    public void TypeInSearchBar(String text) {	
    	searchBox.sendKeys(text);	
    }
    
    public void PressEnterAfterTyping() {
    	searchBox.sendKeys(Keys.ENTER);
    }
    
	//Locate Appium
    
    @FindBy(xpath = "(//div[@role='link'][normalize-space()='Appium'])[1]")
    private WebElement appiumLink;
    
    public String GetAppiumLinkText() {
    	return appiumLink.getText();	
    }

    public void clickAppiumLink() {
    	
    	appiumLink.click();
    	
    }
}
