package appTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Themes {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage","com.android.settings");
		capabilities.setCapability("appActivity","Settings");
		//mCurrentFocus=Window{87e54c6 u0 com.android.contacts/com.android.contacts.activities.PeopleActivity}
		driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//*[text='Themes']/following-sibling::miui:id/arrow_right")).click();
	  driver.findElement(By.xpath("//*[text='Ocean Breeze']")).click();
	  driver.findElement(By.id("com.android.thememanager:id/applyBtn")).click();
	  Thread.sleep(5000);
  }
}
