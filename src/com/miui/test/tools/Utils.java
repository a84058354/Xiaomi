package com.miui.test.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiDevice;

public class Utils {
    public static String LOGTAG = "POWERTEST";
    public static String LOG_PATH = "/sdcard/PowerTest.txt";
    public static long WAIT_MS = 1000;
    public static long LAUNCH_WAIT_MS = 3000;
  //public static long TEST_MS = 12000;// 30 minutes 1800000
  public static long TEST_MS = 1800000;
 //  public static long TEST_MS = 10000;
    public static int SWIPE_STEPS = 6;
   public static String[] JOBLIST = new String[] {

	   "T01_Call",
    "T02_Camera",
    "T03_Record",
   "T04_MXPlayer",
      "T05_Browser",
        "T06_Game",
      "T07_Music_Common",
      "T08_Music_Senior",
   "T09_Email",
         "T10_SlidingScreen",
          "T11_TimesOfIndia",
    	//"T12_GoogleNews",
    	"T13_Facebook",
          //"T14_Bluetooth"
	  "LaunchApps"
    };
/*  public static String[] JOBLIST = new String[] {
	  "T09_Email"
	 
   };*/
    // Save log in device
    public static void log(String msg) {
        FileWriter writer = null;
        try {
            File f = new File(LOG_PATH);
            if (!f.exists()) {
                f.createNewFile();
            }
            writer = new FileWriter(LOG_PATH, true);
            writer.write(msg + "\n");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                log(e.toString());
            }
        }
    }

    public static void excuteCMD(String command) {
        try {
            Runtime.getRuntime().exec(command);
            
            
        } catch (Exception e) {
            log("Exception in method 'excuteCMD()' " + command + ".");
        }
    }

    public static String getCurrentBatteryValue() {
        String path = "/sys/class/power_supply/";
        File[] files = new File(path).listFiles();
        for (File f : files) {
            if (f.getName().contains("battery")) {
                path += (f.getName() + "/capacity");
            }
        }
        String batteryValue = "-1";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            batteryValue = reader.readLine();
        } catch (Exception e) {
            log(e.toString());
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                log(e.toString());
            }
        }

        return batteryValue;
    }

    public static void sleepMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void catchException(Exception e, String img) {
        Utils.log(e.toString());
        Utils.excuteCMD("screencap -p /sdcard/" + img + ".png");
        Utils.sleepMs(2000);
    }

    public static void SaveBugreport() {
        try {
            Runtime.getRuntime()
                    .exec(new String[] {
                            "sh",
                            "-c",
                            "bugreport>/sdcard/bugreport"
                                    + new SimpleDateFormat("MMddHHmm")
                                            .format(new Date()) + ".txt" })
                    .waitFor();
            Utils.sleepMs(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    
    public static void swipeDown(){
    	try{
    	Utils.excuteCMD("input touchscreen swipe 230 700 230 990");
    	}
                    catch (Exception e) {
                        e.printStackTrace();
                    }             }
    
    public static void swipeUp(int numberofTimes){
    	int num=numberofTimes;
    	try{
    		for (int ii=0;ii<=num;ii++){
    	Utils.excuteCMD("input touchscreen swipe 130 1220 130 720");
    	Utils.sleepMs(1000);
    	}}
                    catch (Exception e) {
                        e.printStackTrace();
                    }             }
    
    public static String BatteryValue() throws IOException {
    	
    	char neme = 0;
    	String string1 = "Battery ";
    	
    	  InputStream in = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "dumpsys battery |grep level"}).getInputStream();
          //  InputStream in = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "cp /sdcard/tsens_logger.csv /sdcard/debatanu.csv"}).getInputStream();


            while (true) {
                int ch = in.read();
                if (ch != -1) {
                    System.out.print((char) ch);
                    neme=(char) ch;
                    string1 = string1.concat(Character.toString(neme));
                } else {
                	//String string1 = Character.toString(neme);
                	string1 = string1.concat(Character.toString(neme));
                    return string1;
                }
            }
        } 
    
    
        
                       
    	/*String s = null;
    		Runtime rt = Runtime.getRuntime();
    		String[] commands = {"dumpsys battery |grep level"};
    		Process proc = rt.exec(commands);
        
    		BufferedReader stdInput = new BufferedReader(new 
    			     InputStreamReader(proc.getInputStream()));

    			BufferedReader stdError = new BufferedReader(new 
    			     InputStreamReader(proc.getErrorStream()));
    			
    			
    			while ((s = stdInput.readLine()) != null) {
    			    System.out.println(s);
   
    			 }
    			log(s);
        return s;*/
		//return LOGTAG;
   
    }
    
    

