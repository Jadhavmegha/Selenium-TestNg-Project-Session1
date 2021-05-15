package com.seleniumtest.pkg1.session1;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		String filePath= System.getProperty("user.dir")+"\\Config\\config.properties";
		
		// Scan for file OR check if file exists 
		FileInputStream fi= new FileInputStream(filePath);
		
		// If exists load
		Properties p= new Properties();
		p.load(fi);
		
		// Read file 
		String os_value=p.getProperty("os");
		String url_value = p.getProperty("url_calculator");
		System.out.println("OS value is "+os_value);
		System.out.println("OS value is "+url_value);
		fi.close();

	}

}
