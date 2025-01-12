package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Function;

public class LoginFormPage extends Function {
	
	AndroidDriver driver;

    public LoginFormPage(AndroidDriver driver) {
    	
    	super(driver); // for Functions Class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    
    // Locate the country selector dropdown
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelector;

    
    
    // Dynamic locator for selecting a country by name
    
    public void selectCountryByName(String countryName) {
    	
    	countrySelector.click();
    	
    	scrollTo(countryName);
    	
        String uiAutomatorSelector = "new UiSelector().text(\"" + countryName + "\")";
        WebElement selectCountry = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorSelector));
        selectCountry.click();    
    }

    
    

    // Locate the name text field
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameTextField;

    public void userName(String name) {
        nameTextField.sendKeys(name);
    }
    
    

    // Locate the female gender radio button
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleGenderSelector;

    public void clickFemaleRadioBtn() {
        femaleGenderSelector.click();
    }
    
    
    
    // Locate the male gender radio button
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleGenderSelector;

    public void clickMaleRadioBtn() {
        maleGenderSelector.click();
    }

    
    
    // Locate the "Let's Shop" button
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBtn;

    public void clickLetsShopBtn() {
        letsShopBtn.click();
    }
}
