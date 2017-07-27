package appTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;

	@BeforeMethod()
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "6.0.1"); 
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","android");
		
		
		 capabilities.setCapability("appPackage","com.android.camera");
		// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appActivity","Camera"); // This is Launcher activity of your app (you can get it from apk info app)
	//	Create RemoteWebDriver instance and connect to the Appium server
		 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
			//capabilities.setCapability("autoGrantPermissions", "true");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
  @Test
	public void LaunchApps()throws Exception{
//DesiredCapabilities capabilities = new DesiredCapabilities();

//capabilities.setCapability("appPackage","com.android.camera");
//capabilities.setCapability("appPackage","com.miui.home");
	// This package name of your app (you can get it from apk info app)
	//	capabilities.setCapability("appActivity","Camera");  
	  System.out.println("hi");
	  WebElement wb = driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal"));
	  wb.click();
	  System.out.println("hi");
}

  //Process p = Runtime.getRuntime().exec("cmd.exe /c start dir ");



}