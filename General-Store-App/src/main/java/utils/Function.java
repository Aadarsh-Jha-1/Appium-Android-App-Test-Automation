package utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Function {
	
	AndroidDriver driver;
	
	public Function(AndroidDriver driver) {
        this.driver = driver;
        }
	
	//Scrolling Function (Scroll till the element is found)
	
		public void scrollTo(String targetText) {
	        driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + targetText + "\"));"
	        ));
	    }
		
		
		
		// Long Press On Element
		
		public void longPressOn(WebElement ele) {
			
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId()
			));
			
		}
		
		
		// switch context
		
		public void switchContextTo(String contextName) {
		    try {
		        // Get all available contexts
		        Set<String> contexts = driver.getContextHandles();
		        System.out.println("Available contexts: " + contexts);

		        // Validate if the requested context is available
		        if (contexts.contains(contextName)) {
		            driver.context(contextName);
		            System.out.println("Switched to context: " + contextName);
		        } else {
		            System.out.println("Context '" + contextName + "' not found! Staying in the current context.");
		        }
		    } catch (Exception e) {
		        System.out.println("Error while switching context: " + e.getMessage());
		    }
		}


}
