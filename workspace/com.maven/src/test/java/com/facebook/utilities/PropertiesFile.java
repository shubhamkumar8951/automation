package com.facebook.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import com.gargoylesoftware.htmlunit.javascript.host.file.File;

@SuppressWarnings("unused")
public class PropertiesFile {
	public static Properties readPropertiesFile(String filename)
	{
		Properties properties = null;
		try{
			File file = new File("data\\"+filename+".properties");
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
			fis.close();
			
		}
		catch (Exception e){
			System.out.println("did not work");
		}
		return properties;
	}
	

}
