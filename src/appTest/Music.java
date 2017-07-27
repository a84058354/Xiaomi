package appTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Music {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage","com.miui.player");
		capabilities.setCapability("appActivity","ui.MusicBrowserActivity");
		  //mCurrentFocus=Window{96e2fd5 u0 com.miui.player/com.miui.player.ui.MusicBrowserActivity}
		driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
  @Test
 
  public void f() throws InterruptedException 
  {
	  WebElement wb1= driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	  if(wb1.isDisplayed())
	  {  
	 wb1.click();
	 }
	  else
	  {
		 // WebElement wb2 = driver.findElement(By.id("com.miui.player:id/local_download"));
		 // wb2.click();
	  }
	  WebElement wb2 = driver.findElement(By.id("com.miui.player:id/local_download"));
	  wb2.click();
	  WebElement wb3 = driver.findElement(By.id("com.miui.player:id/play_all"));
	  wb3.click();
	  Thread.sleep(50000);
 }
  @AfterTest
  public void stop(){
	 driver.quit(); 
  }}
