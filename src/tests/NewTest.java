package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import mainfile.Launch;

public class NewTest 
{
	   WebDriver driver;
	   //Capabilities cd=new Capabilities();
	   Launch ln = new Launch();
       @Test
       public void f() throws MalformedURLException, InterruptedException 
       
       {
    	   ln.launchSetting();
    	   Thread.sleep(3000);
    	   driver.findElement(By.xpath("//*[@text='Bluetooth']")).click();
    	   
       }
}
