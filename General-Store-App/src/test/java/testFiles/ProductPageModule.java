package testFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageModule extends AppiumServiceController  {
	
	// Product Names To Be Selected
	
	String product1 = "Jordan 6 Rings";
	
	String product2 = "Jordan Lift Off";
	
	
	// Index of Add To Cart Buttons For Specific Products
	
	int addTocartIndexProd1 = 1;
	
	int addTocartIndexProd2 = 2;
	
	
	@Test(priority =3)
	public void addToCart() throws InterruptedException {
		
		loginFormPage.NavigateToProductPage();
		
		productPage.AddProductToCart(product1,addTocartIndexProd1);
		
		Thread.sleep(1000);
		
		Assert.assertTrue(productPage.AddedToCartMessage(0).isDisplayed(), "Added To Cart Message Not Displayed");
		
		productPage.AddProductToCart(product2,addTocartIndexProd2);
		
		Thread.sleep(1000);
		
		Assert.assertTrue(productPage.AddedToCartMessage(1).isDisplayed(), "Added To Cart Message Not Displayed");
		
		Assert.assertEquals(productPage.NumberOfProductsInCart(), "2");
		
		Thread.sleep(3000);
		
	}
	
	

}
