package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import com.seleniumtest.tesNG.HardAssertCode;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Insurance_Login {
	
	WebDriver driver;
	SoftAssert st;
	
	
  
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	 st=new SoftAssert();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void verifyLogin() {
	  
	  driver.get("http://demo.borland.com/InsuranceWebExtJS/");
	  driver.findElement(By.id("login-form:email")).sendKeys("seleniumtesting@gmail.com");
	  driver.findElement(By.cssSelector("input[id='login-form:password']")).sendKeys("test@123");
	  driver.findElement(By.cssSelector("input[id='login-form:login']")).click();
	  String user=driver.findElement(By.xpath("//*[@id=\"logout-form\"]/div[2]/label")).getText();
	  System.out.println("Logged in user:"+user);
	  st.assertEquals(user, "Selenium Testing");
	 // st.assertAll();
  }
  
  @Test
  public void verifyServiceDetails() {
	  
	  WebElement service= driver.findElement(By.id("quick-link:jump-menu"));
	  Select s= new Select (service);
	  s.selectByValue("quote_auto.jsf");
	  String serviceLabel=driver.findElement(By.xpath("//*[@id=\"content-main\"]/h1")).getText();
	  st.assertEquals(serviceLabel,"Automobile Instant Quote");
	  String pageTitle=driver.getTitle();
	  st.assertTrue(pageTitle.contains("Automobile Instant Quote"), "Page title is wrong");
	  st.assertAll();
  }

  @AfterTest
  public void afterTest() {
  }

}
