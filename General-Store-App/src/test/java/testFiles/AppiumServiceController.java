package testFiles;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

//Function To Start Appium Service And Launch App

public class AppiumServiceController {
	public AndroidDriver driver;
	
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//royal//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro");
		options.setApp("C://Users//royal//Documents//Appium Project//General-Store-App//src//test//java//resources//General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		Thread.sleep(5000);
		
	}
	
	
	// Function To Close/Stop Appium Servers
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop(); 
	}
	

}
