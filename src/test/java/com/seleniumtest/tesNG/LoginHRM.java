package com.seleniumtest.tesNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginHRM {
	
	String projectPath;
	
	WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath= System.getProperty("user.dir");
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
  }
  
  @Test
  public void Login() throws InterruptedException {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window();
		// Step 1: Clear before entering username
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		//Thread.sleep(2000);
		
		/*driver.findElement(By.id("welcome")).click();    //Credentials are failing on site due to technical issue
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click(); */
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
