package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public static Properties configPropertiesLoader() {
		
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\propertiesFiles\\config.properties");
		FileInputStream propFIS;
		try {
			propFIS = new FileInputStream(propFile);
			prop.load(propFIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static Properties testDataPropertiesLoader() {
		Properties testData = new Properties();
		File testDataFile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\propertiesFiles\\testData.properties");
		FileInputStream testDataFIS;
		try {
			testDataFIS = new FileInputStream(testDataFile);
			testData.load(testDataFIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
		
	}
	
	
}
