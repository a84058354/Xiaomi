package mainfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Adb 

{
	public static String LOG_PATH = "/sdacrd/Test.txt";
	 public  void excuteCMD(String command) {
	        try {
	            Runtime.getRuntime().exec(command);
	            
	            
	        } catch (Exception e) {
	            log("Exception in method 'excuteCMD()' " + command + ".");
	        }
	    }
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

}