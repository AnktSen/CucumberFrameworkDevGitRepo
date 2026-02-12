package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			System.err.println("Error: Could not find or read config.properties at the specified path.");
			e.printStackTrace();
		}
		return prop;
	}
	public static String getProp(String key) {
		if (prop == null) {
			new ConfigReader().init_prop();
		}
		return prop.getProperty(key);
	}
}