package testFiles;

import java.util.Set;

import org.testng.annotations.Test;

public class NavigateToBrowser extends AppiumServiceController {
	
	@Test
	public void HybridAppAutomationFlow() throws InterruptedException {
		
		NavigateToBrowserAfterCart();
		
		// Get all contexts
		Set<String> contexts = driver.getContextHandles();
		System.out.println("Available contexts: " + contexts);
		
		// Switch to browser context
		driver.context("WEBVIEW_com.androidsample.generalstore");

	}

}
