package com.frameworkTest01.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesClass {
	 
	static Properties properties = new Properties();
	public static Properties readPropertyFile(String fileName) throws IOException{
		File file = new File("data\\"+fileName+".properties");
		FileInputStream fs = new FileInputStream(file);
		properties.load(fs);
		fs.close();
		return properties;
	}

}
