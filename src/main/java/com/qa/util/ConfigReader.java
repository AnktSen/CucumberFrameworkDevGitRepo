package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	public Properties init_prop() throws FileNotFoundException {
		prop =new Properties();
		FileInputStream ip =new FileInputStream("./src/test/resources/config/config.properties");
		return prop;
	}
	
}
