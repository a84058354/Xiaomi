package tests;

import org.testng.annotations.Test;

import mainfile.Capabilities;
import mainfile.Launch;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1  {
	WebDriver driver;
	Capabilities cd=new Capabilities();
	
	Launch ln = new Launch();
	@Test(priority=1)
	public void Launch() throws InterruptedException, MalformedURLException
	{
		ln.launchCamera();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		Thread.sleep(5000);
		
	}
	@Test(priority=2)
	public void permission()
	{
	//driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.name("Allow")).click();
	}
	
//  public void capture() throws MalformedURLException, InterruptedException 
//	{
//		
//	      permission();
//	      driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal")).click();
//		 
//		  cd.home();
//      }
//
//   public void recordVideo() throws InterruptedException, MalformedURLException
//   {
//	   permission();
//	   driver.findElement(By.id("com.android.camera:id/v6_module_picker")).click();
//	   Thread.sleep(3000);
//	   driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal")).click();
//	   Thread.sleep(10000);
//	   driver.findElement(By.id("com.android.camera:id/v6_shutter_button")).click();
//	   Thread.sleep(3000);
//	   driver.findElement(By.id("com.android.camera:id/v6_module_picker")).click();
//	   Thread.sleep(2000);
//	   cd.home();
//   }
//    public void selfiePic() throws InterruptedException, MalformedURLException
//    {
//    	permission();
//    	driver.findElement(By.id("com.android.camera:id/v6_camera_picker")).click();
//    	Thread.sleep(2000);
//    	driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal")).click();
//    	Thread.sleep(2000);
//    	 cd.home();
//    }
//    public void selfieRecord() throws InterruptedException, MalformedURLException
//    {
//    	permission();
//    	driver.findElement(By.id("com.android.camera:id/v6_module_picker")).click();
//    	Thread.sleep(3000);
//    	driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal")).click();
//    	Thread.sleep(10000);
//    	driver.findElement(By.id("com.android.camera:id/v6_shutter_button")).click();
//    	Thread.sleep(2000);
//    	cd.home();
//    }
//	public void	mode() throws MalformedURLException, InterruptedException
//	{
//		permission();
//		driver.findElement(By.id("com.android.camera:id/mode_button")).click();
//	}
//	
 

}
