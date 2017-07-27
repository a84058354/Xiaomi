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

public class NewTest3 {
	WebDriver driver;
	//UiObject=new 
	@BeforeMethod()
	public void setUp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("VERSION", "6.0.1"); 
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","android");
		capabilities.setCapability("appPackage","com.android.mms");
		capabilities.setCapability("appActivity","ui.MmsTabActivity"); 
		  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
  @Test
  public void f() {
	
	  driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	  driver.findElement(By.xpath("//*[@text='Activate']")).click();
	  
	  
	  WebElement wb= driver.findElement(By.id("com.android.mms:id/fab"));
	  wb.click();
	  WebElement wb1= driver.findElement(By.id("com.android.mms:id/recipients_editor"));
	  wb1.sendKeys("9498007353");
	  WebElement wb2= driver.findElement(By.id("com.android.mms:id/editor_container"));
	  wb2.sendKeys("edhwbcoejdnewcjonowcnjewncovhcnionconovncocnoconbbcocwbn");
	  WebElement wb3= driver.findElement(By.id("com.android.mms:id/send_button"));
	  wb3.click();
	  
  }
  

}


