package com.seleniumtest.tesNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	String projectPath;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		driver= new ChromeDriver();
  }
  
  @Test
  public void LoginM1() {
	  
	// Step 1: Open application
			driver.get("http://demo.testfire.net/login.jsp");
			
			//Step 2: Enter username
			driver.findElement(By.id("uid")).sendKeys("admin");
			
			//Step 3: Enter password
			driver.findElement(By.id("passw")).sendKeys("admin");
			
			//Step 4: Click on login button
			driver.findElement(By.name("btnSubmit")).click();
			
			//Step 4: Click logout
			driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
			
			Reporter.log("Mutual login successful");

  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
