package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilesFiles {
	
	
	
	public static Properties propertiesFile() throws IOException {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\Resource\\Config\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		return prop;
	}
	
	public static String randaemailid() {
		
		int length =5;
		String random = RandomStringUtils.randomAlphanumeric(length);
		return random+"@gmail.com";
		
		
	}

}
