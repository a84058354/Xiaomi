package appTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Precondition {
	WebDriver driver;
	
	@BeforeMethod()
	public void setUp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("VERSION", "6.0.1"); 
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","android");
		capabilities.setCapability("appPackage","com.android.settings");
		capabilities.setCapability("appActivity","Settings"); 
		capabilities.setCapability("autoGrantPermissions", "true");
		  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
  @Test
  public void f()throws Exception {
	
	  //( driver).scrollTo("Permissions");
  }
}
