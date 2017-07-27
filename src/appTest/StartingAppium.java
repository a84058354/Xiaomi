package appTest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.CommandLine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class StartingAppium {
	WebDriver driver;
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void setUp() throws Exception {
		String osName = System.getProperty("os.name");
		if (osName.contains("Android")) {
	     service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
	             .usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
	             .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
	             .withIPAddress("127.0.0.1")
	             .usingPort(port)
	             .withLogFile(new File("target/"+deviceUnderExecution+".log")));
	 } 
	 elseif(osName.contains("Windows"))
	 {
	     service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
	             .usingPort(port)
	             .withLogFile(new File("target/"+deviceUnderExecution+".log")));
	 } 
	 else 
	 {
	     Assert.fail("Unspecified OS found, Appium can't run");
	 }

	 System.out.println("- - - - - - - - Starting Appium Server- - - - - - - - ");
	 
	 2.
	 service.start();
	 service = AppiumDriverLocalService.buildDefaultService();
		 service.start();
		 
		 3. 
		 
		 Public static void changeDriverContextToNative(AppiumDriver driver) {
			    Set<String> contextNames = driver.getContextHandles();
			    for (String contextName : contextNames) {
			        if (contextName.contains("NATIVE"))
			            DriverFactory.driver.context(contextName);
			    }
			}
		 service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                 .usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
                 .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
                 .withIPAddress("127.0.0.1")
                 .usingPort(port)
                 .withLogFile(new File("target/"+deviceUnderExecution+".log")));
	}
  @Test
  public void f() {
  }
}
