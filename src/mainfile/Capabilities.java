package mainfile;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSTouchAction;

public class Capabilities 
{
	
	WebDriver driver;
  
  
  public void MainCapabilities(String appName,String packageName) throws MalformedURLException 
  {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appPackage",appName);
		capabilities.setCapability("appActivity",packageName);
		driver =new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}

public void scroll() throws InterruptedException
  {
	  Dimension dimensions = driver.manage().window().getSize();
	  Double screenHeightStart = dimensions.getHeight() * 0.5;
	  int scrollStart = screenHeightStart.intValue();
	  System.out.println("s="+scrollStart);
	  Double screenHeightEnd = dimensions.getHeight() * 0.2;
	  int scrollEnd = screenHeightEnd.intValue();
	  ((AndroidDriver) driver).swipe(0,scrollStart,0,scrollEnd,2000);
	  Thread.sleep(10000);
  }
  @SuppressWarnings("rawtypes")
public void scrollTill(By by)
  {
	  //by = By.xpath("//*[@text='Permissions']");
	  Dimension dimensions = driver.manage().window().getSize();
      Double screenHeightStart = dimensions.getHeight() * 0.5;
      int scrollStart = screenHeightStart.intValue();
      System.out.println("s="+scrollStart);
      Double screenHeightEnd = dimensions.getHeight() * 0.2;
      int scrollEnd = screenHeightEnd.intValue();
      ((AndroidDriver) driver).swipe(0,scrollStart,0,scrollEnd,2000);
      
      for (int i=0;i<dimensions.getHeight();i++) 
      {

      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      try
      {
      driver.findElement(by).click();
   
      break;
      }
      catch (Exception e)
      {
      scrollTill(by);
      }
      }
  }
  @SuppressWarnings("rawtypes")
public void back()
  {
	  ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
  }
  @SuppressWarnings("rawtypes")
public void home()
  {
	  ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
  }
  
  @SuppressWarnings("rawtypes")
public void powerbtn()
  {
	  ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
  }
  
  public void screenUnlock()
  {
	  if (((AndroidDriver) driver).isLocked())
          ((AndroidDriver) driver).unlockDevice();
	  else{
		  System.out.println("device unlock");
	      }
	  }
  public void longPress()
  {
  ((AndroidDriver) driver).findElementByAccessibilityId("longPress").click();
  WebElement longpress = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("longpress")));
  new TouchAction((PerformsTouchActions) driver).longPress(longpress,3000).perform();
  assertTrue(driver.switchTo().alert().getText().contains("Long Pressed"));
  }
  public void doubleTap() throws InterruptedException {
    
      ((AndroidDriver) driver).findElementByAccessibilityId("doubleTap").click();
      MobileElement doubleTap = (MobileElement) new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("doubleTapMe")));
      new IOSTouchAction((PerformsTouchActions) driver).doubleTap(doubleTap).perform();
      Thread.sleep(2000);
      assertTrue(driver.switchTo().alert().getText().contains("Double tap successful!"));
  }
  
}


  

  
  

