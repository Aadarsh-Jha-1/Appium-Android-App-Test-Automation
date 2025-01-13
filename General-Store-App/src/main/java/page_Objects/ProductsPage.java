package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
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

}
