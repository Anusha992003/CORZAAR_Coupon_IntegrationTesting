package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	public Properties init_prop() {
		prop = new Properties();
		File file = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getProperty(String key) {

		return prop.getProperty(key);
	}

}
