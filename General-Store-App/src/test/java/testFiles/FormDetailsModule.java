package testFiles;

import org.testng.annotations.Test;

import page_Objects.LoginFormPage;
import utils.Function;

public class FormDetailsModule extends AppiumServiceController {
	
	@Test
	public void FillForm() throws InterruptedException {
		
		LoginFormPage loginFormPage = new LoginFormPage(driver);
		
		loginFormPage.selectCountryByName("India");
		
		loginFormPage.userName("Test User");
		
		loginFormPage.clickFemaleRadioBtn();
		
		loginFormPage.clickLetsShopBtn();
		
		Thread.sleep(5000);
		
	}

}
