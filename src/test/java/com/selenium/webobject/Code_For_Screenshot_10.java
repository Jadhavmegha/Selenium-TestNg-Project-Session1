package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {

		w.get("https://www.google.com");

		String projectPath = System.getProperty("user.dir");
		String filename = "GooglePage";
		
		
        //TakesScreenshot Interface is use to take screenshot
		
		TakesScreenshot ts = (TakesScreenshot) w;
		
		//Convert screenshot to file.
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//Save file in giving location.
	FileUtils.copyFile(source, new File(projectPath + "\\" + filename + ".png"));

		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
