package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestCondiumDev {
	
	String projectPath;
	WebDriver driver;
	SoftAssert st;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  st=new SoftAssert();
	  
  }
  
  @Test
  public void homePage () {
	  
 
	  driver.get("https://compendiumdev.co.uk/");
	  driver.manage().window().maximize();
	  
	  WebElement pageLabel= driver.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div/h1"));
	  String pageLabelText= pageLabel.getText();
	  System.out.println("PageLabelText:"+pageLabelText);
	  st.assertEquals(pageLabelText,"Do you want to test and develop software better?");
	  
	  String pageTitle= driver.getTitle();
    st.assertTrue(pageTitle.contains("Software Testing"), "Page Title does not have specified title");
  }
	  
	 @Test
	 
	  public void e_trainingPage() {
		 
	  driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a")).click();
	  String etrainingtitle= driver.getTitle();
	  st.assertTrue(etrainingtitle.contains("Online Training"));
	 }
	 
	 @Test
	 public void bookPage() {
		 
	  driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[3]/a")).click();
	  String bookPageTitle= driver.getTitle();
	  st.assertEquals(bookPageTitle, "Our Books");
	  
	  st.assertAll();
	 } 
	  
	  
  

 

@AfterTest
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
