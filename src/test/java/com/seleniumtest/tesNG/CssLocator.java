package com.seleniumtest.tesNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CssLocator {
  
	String projectPath;
	WebDriver driver;
  
  @BeforeTest
  public void preCondition() {
	  
	  projectPath=System.getProperty("user.dir");
	  
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();  
	  
  }
  
  @Test
  public void cssMethods() throws InterruptedException {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	  driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
	  driver.findElement(By.cssSelector("input[class='button']")).click();
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("Welcome Paul")).click();
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
