package testFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageModule extends AppiumServiceController {
	
	@Test 
	
	public void validationsOnCartPage() throws InterruptedException{
		
		AddToCart();
		
		productPage.clickCartBadge();
		
		Thread.sleep(3000);
		
		//Validate Page Title
		Assert.assertTrue((cartPage.getCartPageTitle()).equals("Cart"));
		
		//Validate Product Visibility
		Assert.assertTrue(cartPage.productLocator("Jordan 6 Rings").isDisplayed());
		Assert.assertTrue(cartPage.productLocator("Jordan Lift Off").isDisplayed());
		
		
		// Validate Price Calculation
		float calculatedTotalPrice = cartPage.getProductPrice(0) + cartPage.getProductPrice(1);
		float onPageTotalPrice = cartPage.getTotalPrice();
		Assert.assertTrue(calculatedTotalPrice == onPageTotalPrice);
		
		//Subscribe To E-mails check-box
		cartPage.clickSubscribeEmailsCheckbox();
		Thread.sleep(2000);
		Assert.assertTrue((cartPage.isCheckBoxChecked()).equals("true"));
		
		// Terms and condition alert 
		cartPage.getTermsAndConditions();
		Thread.sleep(2000);
		Assert.assertTrue((cartPage.getTermsAndConditionsAlertTitle()).equals("Terms Of Conditions"));
		cartPage.closeTermsAndConditionAlert();
		Thread.sleep(2000);
		
		//Click On Proceed Button To Submit
		
		cartPage.clickProceedBtn();
		Thread.sleep(5000);
		
		
		
	}
	
	

}
