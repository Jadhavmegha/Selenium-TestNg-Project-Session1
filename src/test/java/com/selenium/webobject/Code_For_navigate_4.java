package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_navigate_4 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_navigate() throws Exception {
		
	//	w.get("https://demo.testfire.net/login.jsp");
		  
		 //OR
		
		w.navigate().to("https://www.selenium.dev/");

		Thread.sleep(3000);
		
		w.findElement(By.xpath("//a[text()='Downloads']")).click();
		
		Thread.sleep(3000);

		w.navigate().back();
		
		Thread.sleep(3000);

		w.navigate().forward();
		
		Thread.sleep(3000);		
		
		w.navigate().back();


		Thread.sleep(3000);		
		
		w.findElement(By.xpath("//a[text()='Projects']")).click();
		
		Thread.sleep(3000);

		w.navigate().refresh();
        
	}

	@AfterTest
	public void afterTest() {

		//w.quit();
	}

}
