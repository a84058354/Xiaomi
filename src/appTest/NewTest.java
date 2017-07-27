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

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;

import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings("deprecation")
public class NewTest {
	 UiDevice ud;
	WebDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage","com.android.contacts");
		capabilities.setCapability("appActivity","activities.PeopleActivity");
		//mCurrentFocus=Window{87e54c6 u0 com.android.contacts/com.android.contacts.activities.PeopleActivity}
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
 
@Test


  public void f() throws UiObjectNotFoundException, InterruptedException {
	  WebElement wb1= driver.findElement(By.id("com.android.contacts:id/fab"));
	  wb1.click();
	  Thread.sleep(2000);
	  
	  WebElement wb2 =driver.findElement(By.xpath("//*[@text='Name']"));
	  wb2.sendKeys("Ankita Singh");
	  WebElement wb3 =driver.findElement(By.xpath("//*[@text='Company']"));
	  wb3.sendKeys("Xiaomi");
	  WebElement wb4 =driver.findElement(By.xpath("//*[@text='Title']"));
	  wb4.sendKeys("OK OK");
	  WebElement wb5 = driver.findElement(By.xpath("//*[@text='Phone']"));
	  wb5.sendKeys("9498007353");
	  Thread.sleep(5000);
	
	 
	
	 // WebElement wb6 = driver.findElement(By.xpath("//*[@text='Email']"));
	//  wb6.sendKeys("singh.ankita27@gmail.com");
	  WebElement wb7 = driver.findElement(By.xpath("//*[@text='OK']"));
	  wb7.click();
	  Thread.sleep(5000);
	 
	 
	  clickBackButton();
//	  Thread.sleep(2000);
//	  DesiredCapabilities capabilities = new DesiredCapabilities();
//	  capabilities.setCapability("appPackage","com.android.contacts");
//	  capabilities.setCapability("appActivity","activities.PeopleActivity");
	  Thread.sleep(3000);
	  WebElement wb8 =driver.findElement(By.id("android:id/input"));
	  wb8.clear();
	  wb8.sendKeys("Ankita");
	  
}
	  public void clickBackButton()
	  {
		    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}
  

  

}
