package com.seleniumtest.tesNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAsserCode {
	String projectPath;
	WebDriver driver;
	SoftAssert st;
  
  @BeforeTest
  public void preCondition() {
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
  }
  
  @Test (priority=0, description="test to verify login functionallity")
  public void LoginTest() throws InterruptedException {
	  driver.get("http://demo.testfire.net/login.jsp");
	  st=new SoftAssert();
	  
	  //Verify page title is "Altoro Mutual"
	  String pageTitle= driver.getTitle();
	  //SoftAssert
	  st.assertEquals(pageTitle, "Altoro Mutul");
	  
	  // Verify page label has "Login"
	  
	  WebElement pageLabel= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  
	  String loginLabel=pageLabel.getText();
	  st.assertTrue(loginLabel.contains("Login"));
	  
	  driver.findElement(By.id("uid")).sendKeys("admin");
	  driver.findElement(By.id("passw")).sendKeys("admin");
	  driver.findElement(By.name("btnSubmit")).click();
	  Thread.sleep(2000);
	  //st.assertAll();
	  
  }
  
  @Test (priority=0, description="test to verify login functionallity")
  public void LogoutTest() {
	  
	  st=new SoftAssert();
	 
	  //Verify page title is "Altoro Mutual"
	  String pageTitle= driver.getTitle();
	  
	  //SoftAssert
	  st.assertEquals(pageTitle, "Altoro Mutual");
	  
	  // Verify page label has "Login"
	  
	  WebElement pageLabel= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  
	  String logoutLabel=pageLabel.getText();
	  st.assertTrue(logoutLabel.contains("Admin"));
	  
	  driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  st.assertAll();
	  
  }

  @AfterTest
  public void postCondition() {
	  
	  driver.close();
  }
}
