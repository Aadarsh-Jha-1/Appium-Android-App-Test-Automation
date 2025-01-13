package testFiles;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import page_Objects.LoginFormPage;
import page_Objects.ProductsPage;

public class AppiumServiceController {

    protected AndroidDriver driver;
    private AppiumDriverLocalService service;

    // Page Object declarations
    protected LoginFormPage loginFormPage;
    protected ProductsPage productPage;

    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
        // Start Appium service
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//royal//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        // Set capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 7 Pro");
        options.setApp("C://Users//royal//Documents//Appium Project//General-Store-App//src//test//java//resources//General-Store.apk");

        // Initialize driver
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        
        //Wait For App To Be Launched
        Thread.sleep(5000);

        // Initialize page objects
        initializePageObjects();
    }

    private void initializePageObjects() {
        loginFormPage = new LoginFormPage(driver);
        productPage = new ProductsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
