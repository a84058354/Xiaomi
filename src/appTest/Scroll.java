package appTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;

public class Scroll
{
		WebDriver driver;
		@SuppressWarnings("rawtypes")
		@BeforeMethod
		public void setup() throws MalformedURLException, InterruptedException
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("VERSION","6.0.1");
			capabilities.setCapability("deviceName","Redmi");
			capabilities.setCapability("platformName", "android");
			capabilities.setCapability("appPackage","com.android.settings");
			capabilities.setCapability("appActivity","Settings"); 
			
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}
	
 
          @Test
         public void scroll() throws InterruptedException 
        {
	    By by = By.xpath("//*[@text='Permissions']");
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
        driver.findElement(By.xpath("//*[@text='Permissions']")).click();
     
        break;
        }
        catch (Exception e)
        {
        scroll();	
        }
        }
        }

}
     

