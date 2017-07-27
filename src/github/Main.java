package github;

import org.testng.annotations.Test;

public abstract class Main extends Helper{
  @Test
  public void f() {
	 

			@Override
			protected void setAppiumDriver() throws IOException {
			    logger.debug("Setting up AndroidDriver");
				this.wd = new AndroidDriver<MobileElement>(new URL(getAppiumServerAddress() + "/wd/hub"),
						capabilities);
			}

		    @Override
		    protected String getServerSideApplicationPath() {
		        return System.getProperty("user.dir") + "/application.apk";
		    }

		    @Override
		    protected String getDesiredCapabilitiesPropertiesFileName() {
		        if (isClientSideTestRun()){
		            return "desiredCapabilities.android.clientside.properties";
		        } else {
		            return "desiredCapabilities.android.serverside.properties";
		        }
		    }
		
  }

}