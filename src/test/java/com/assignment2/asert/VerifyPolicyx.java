package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VerifyPolicyx {
	
	String projectPath;
	WebDriver driver;
	SoftAssert st;
  
  @BeforeTest
  public void preCondition() {
	  
	  projectPath=System.getProperty("user.dir");
	  
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
	  
  }
  
  
  @Test
  public void checkLabel() {
	  
	  driver.get("https://www.policyx.com");
	  driver.manage().window().maximize();
	  st=new SoftAssert();
	  
	 // 1 Verify Label on page is equal to "India's Most Trusted Insurance Portal"
	  
	  String pageLabel = driver.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1")).getText();
	  System.out.println(pageLabel);
	  //Assert.assertEquals(pageLabel, "India's Most Trusted Insurance Portal");		//Hard Assert
	  st.assertEquals(pageLabel, "India's Most Trusted Insurance Portal");		//Soft Assert
	 
	  
	 // 2. Verify page title contains "Insurance" text .
	 
	 String pageTitle= driver.getTitle();
	 System.out.println("PageTitle:"+pageTitle);
	//Assert.assertTrue(pageTitle.contains("Insurance"));		//Hard assert
	 //st.assertTrue(pageTitle.contains("Insurance"));		//Soft assert
	 st.assertTrue(pageTitle.contains("Insurance"), "Page title does not contain Insurance name");
	 
	 //3. On-clicking "Claim", and verify Page label is “CLAIM ASSISTANCE”
	 
	 driver.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
	 WebElement claimLabel= driver.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
	 String claimLabelText=claimLabel.getText();
	 //Assert.assertEquals(claimLabelText, "CLAIM ASSISTANC");	//Hard assert
	 st.assertEquals(claimLabelText, "CLAIM ASSISTANCE");	//Soft assert
	 
	 
	 //4 . Verify page title contains "Claim Process"
	 
	 String claimTitle=driver.getTitle();
	// Assert.assertTrue(claimTitle.contains("Claim Process"));
	 st.assertTrue(claimTitle.contains("Claim Process"));
	 
	 
	st.assertAll();
	 
	  
  }
  
  
  

  @AfterTest
  public void postCondition() {
	  
	  driver.close();
  }
  

}
