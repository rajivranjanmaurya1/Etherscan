package com.etherscan.utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public static String getProperty(String filePath, String property) {
		String propertyValue = null;
		try {
			FileReader reader = new FileReader(filePath);
			Properties configFile = new Properties();
			configFile.load(reader);
			propertyValue= configFile.getProperty(property);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyValue;		
	}
}
