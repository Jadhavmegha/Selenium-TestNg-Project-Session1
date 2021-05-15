package com.seleniumtest.tesNG;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ScientificCalculator {
	
	String projectPath= System.getProperty("user.dir");
	WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
  }
  
  
  @Test(priority=0, description="To verify calculator labels")
  public void calculatorLabels() {
	  
	  driver.get("https://www.tcsion.com/OnlineAssessment/ScientificCalculator/Calculator.html#nogo");
	  String pageTitle=driver.getTitle();
	  Assert.assertEquals(pageTitle, "SCIENTIFIC CALCULATOR");  
	  
	  String currentUrl=driver.getCurrentUrl();
	  System.out.println(currentUrl);
	  Assert.assertTrue(currentUrl.contains("Calculator.html#nogo"), "URL is not correct");
  }
  
  @Test(priority=1, description="To verify calculator operations")
  public void calculatorOp() throws InterruptedException {
	  
	 driver.findElement(By.id("keyPad_btn2")).click();
	 driver.findElement(By.id("keyPad_btnPlus")).click();
	 driver.findElement(By.id("keyPad_btn3")).click();
	 driver.findElement(By.id("keyPad_btnEnter")).click();
	 
	 Thread.sleep(2000);
	 
	 String userInputs= driver.findElement(By.id("keyPad_UserInput")).getAttribute("value");
	 System.out.println(userInputs);
	 
	 
  }

  @AfterTest
  public void afterTest() {
	  
	  //driver.quit();
  }

}
