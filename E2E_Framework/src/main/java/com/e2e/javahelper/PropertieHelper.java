package com.e2e.javahelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertieHelper {

	String fpath;
	Properties pref;

	/**
	 * @param fpath - Provide the path of the properties file
	 */

	public PropertieHelper(String fpath) {
		// TODO Auto-generated constructor stub
		this.fpath = fpath;
		pref = new Properties();
	}

	/**
	 * @param propertiesname
	 * @return value of property name provided
	 * @throws IOException
	 * @author Shridhara
	 * 
	 */
	public String getProperties(String propertiesname) {
		try {
			pref.load(Files.newInputStream(Paths.get(fpath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pref.getProperty(propertiesname);

	}
	/**
	 * @param pname  is properties name
	 * @param pvalue is properties value
	 * @author Shridhara
	 */
	public void setProperties(String pname, String pvalue) {
		pref.setProperty(pname, pvalue);
		try {
			pref.store(Files.newOutputStream(Paths.get(fpath)), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

}
