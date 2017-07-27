package appTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.tools.ant.taskdefs.Sleep;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.uiautomator.core.UiDevice;

import android.content.Intent;
import android.net.Uri;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings({ "deprecation", "unused" })
public class NewTest2 {
	WebDriver driver;
	//UiDevice ud = null;
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void setup() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage","com.android.contacts");
	    capabilities.setCapability("appActivity","activities.TwelveKeyDialer");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		 
	}
 

	@Test
  public void f() throws Exception{
	  Thread.sleep(3000);
      ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(3000);
	  
	  Intent phoneIntent = new Intent(Intent.ACTION_CALL);
	  phoneIntent.setData(Uri.parse("tel:91-000-000-0000"));
} 

	
	  
	
	

	 
}
	    
	 






	
