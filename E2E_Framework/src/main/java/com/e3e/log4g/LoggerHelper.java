package com.e3e.log4g;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerHelper {
	 static{
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	        System.setProperty("current.date.time", dateFormat.format(new Date()));
	    }
	private static boolean root = false;

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clas ){
		if (root) {
			return Logger.getLogger(clas);
					}
		
		String log4jLOcation = System.getProperty("user.dir")+"\\src\\main\\java\\com\\e3e\\log4g\\log.properties";
		PropertyConfigurator.configure(log4jLOcation);
			
		root = true;
		return Logger.getLogger(clas);
}
		
}