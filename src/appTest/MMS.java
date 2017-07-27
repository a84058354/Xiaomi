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

public class MMS {
	WebDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","ui.MmsTabActivity"); 
		
		driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
	}
  @Test
  public void f() throws InterruptedException {
	  WebElement wb= driver.findElement(By.id("com.android.mms:id/fab"));
	  wb.click();
	  WebElement wb1= driver.findElement(By.id("com.android.mms:id/recipients_editor"));
	  wb1.sendKeys("9498007353");
	  WebElement wb2= driver.findElement(By.id("com.android.mms:id/switch_btn"));
	  wb2.click();
	  Thread.sleep(2000);
	  WebElement wb3= driver.findElement(By.xpath("//*[@text='Take photo']"));
	                            
	  wb3.click();
	  driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	  driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 // WebElement wb4= driver.findElement(By.xpath("//*[@text='Camera']"));
	 // wb4.click();
	  WebElement wb5= driver.findElement(By.id("com.android.camera:id/v6_shutter_button"));
	  wb5.click();
	  Thread.sleep(5000);
	  WebElement wb6= driver.findElement(By.id("com.android.camera:id/v6_btn_done"));
	  wb6.click();
	  Thread.sleep(2000);
	 // WebElement wb7 = driver.findElement(By.xpath("//*[@text='Multimedia message (MMS)']"));
	//  wb7.sendKeys("helkllo");
	  WebElement wb8 = driver.findElement(By.id("com.android.mms:id/send_button"));
	  wb8.click();
  }
}
