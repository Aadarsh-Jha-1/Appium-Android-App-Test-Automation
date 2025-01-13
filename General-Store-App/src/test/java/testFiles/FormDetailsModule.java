package testFiles;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_Objects.LoginFormPage;
import page_Objects.ProductsPage;

public class FormDetailsModule extends AppiumServiceController {
	

	// Test Cases
	
	@Test(priority = 1)
	public void ToastErrorValidation() throws InterruptedException {
		
		loginFormPage.clickLetsShopBtn();
		
		Thread.sleep(1000);
		
		String toastError = loginFormPage.getNameToastError();
		
		Assert.assertEquals(toastError,"Please enter your name");
		
	}
	
	
	@Test(priority = 2)
	public void FillForm() throws InterruptedException {
				
		loginFormPage.selectCountryByName("India");
		
		loginFormPage.userName("Test User");
		
		loginFormPage.clickFemaleRadioBtn();
		
		loginFormPage.clickLetsShopBtn();
		
		Thread.sleep(5000);
		
		productPage.getPageTitle();
		
	}
	

}
