package mainfile;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Launch 
{      
	    Capabilities cd=new Capabilities(); 
	    WebDriver driver;
       
	    
        public void launchContacts() throws MalformedURLException  
        { 

        	
        	String appPackage="com.android.contacts";
        	String appActivity="activities.PeopleActivity";
        	cd.MainCapabilities(appPackage, appActivity);
        }
        public void launchCamera() throws MalformedURLException
        {
        	String appPackage="com.android.camera";
        	String appActivity="Camera";
        	cd.MainCapabilities(appPackage, appActivity);
        }
        public void launchSetting() throws MalformedURLException
        {
        	String appPackage="com.android.settings";
        	String appActivity="Settings";
        	cd.MainCapabilities(appPackage, appActivity);
        }
        public void launchMusic() throws MalformedURLException
        {
        	String appPackage="com.miui.player";
        	String appActivity="ui.MusicBrowserActivity";
        	cd.MainCapabilities(appPackage, appActivity);
        }
        public void launchDialer() throws MalformedURLException
        {
        	String appPackage="com.android.contacts";
        	String appActivity="activities.TwelveKeyDialer";
        	cd.MainCapabilities(appPackage, appActivity);
        }
        public void launchMessage() throws MalformedURLException
        {
        	String appPackage="com.android.mms";
        	String appActivity="ui.MmsTabActivity";
        	cd.MainCapabilities(appPackage, appActivity);
        }
       
        
}
