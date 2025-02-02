package testFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class WebViewIntraction extends AppiumServiceController {
	
	@Test
	public void HybridAppAutomationFlow() throws InterruptedException {
		
		NavigateToBrowserAfterCart();
		
		browserPage.SwitchToWebView();
		
		browserPage.TypeInSearchBar("Appium");
		
		Thread.sleep(2000);
		
		browserPage.PressEnterAfterTyping();
		
		Thread.sleep(3000);
		
		System.out.println("Text : "+browserPage.GetAppiumLinkText());
		
		Assert.assertEquals(browserPage.GetAppiumLinkText(),"Appium");
		
		browserPage.clickAppiumLink();
		
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		browserPage.SwitchToNativeApp();
		
		Thread.sleep(2000);
	}

}
