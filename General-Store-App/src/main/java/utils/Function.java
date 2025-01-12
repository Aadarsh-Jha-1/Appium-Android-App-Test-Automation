package utils;

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

}
