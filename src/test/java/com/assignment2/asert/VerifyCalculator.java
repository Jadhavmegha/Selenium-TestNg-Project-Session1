package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class VerifyCalculator {
	
	String projectPath;
	WebDriver driver;
	SoftAssert st;
	
 
  @BeforeTest
  public void preCondition() {
	  
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://juliemr.github.io/protractor-demo/");
	  st=new SoftAssert();
  }
  
  @Test (priority=0, description="Enter 5, Select +, Enter 5 -> Click Go button,Verify 10 value get display.")
  public void test1() throws InterruptedException {
	  
	
	  driver.findElement(By.cssSelector("input[ng-model='first']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");
	  WebElement dropDown=driver.findElement(By.cssSelector("select[ng-model='operator']"));
	  dropDown.click();
	  Select dropDownOption= new Select(dropDown);
	  dropDownOption.selectByValue("ADDITION");
	  driver.findElement(By.cssSelector("input[ng-model='second']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("5");
	  driver.findElement(By.id("gobutton")).click();
	  Thread.sleep(3000);
	  WebElement result= driver.findElement(By.cssSelector("h2[class='ng-binding']"));
	  String resultText= result.getText();
	  System.out.println("Result="+resultText);
	  st.assertEquals(resultText, "10");
	  st.assertAll();
	  
  }
  
  @Test (priority=1, description="Enter 5, Select -, Enter 2 -> Click Go button,Verify 3 value get display.")
  public void test2() throws InterruptedException {
	  
	  
	  driver.findElement(By.cssSelector("input[ng-model='first']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");
	  WebElement dropDown=driver.findElement(By.cssSelector("select[ng-model='operator']"));
	  dropDown.click();
	  Select dropDownOption= new Select(dropDown);
	  dropDownOption.selectByValue("SUBTRACTION");
	  driver.findElement(By.cssSelector("input[ng-model='second']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2");
	  driver.findElement(By.id("gobutton")).click();
	  Thread.sleep(3000);
	  WebElement result= driver.findElement(By.cssSelector("h2[class='ng-binding']"));
	  String resultText= result.getText();
	  System.out.println("Result="+resultText);
	  st.assertEquals(resultText, "3");
	  st.assertAll();
  }
  
  @Test (priority=1, description="Enter 3, Select *, Enter 3 -> Click Go button,Verify 9 value get display.")
  public void test3() throws InterruptedException {
	  
	  driver.findElement(By.cssSelector("input[ng-model='first']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("3");
	  WebElement dropDown=driver.findElement(By.cssSelector("select[ng-model='operator']"));
	  dropDown.click();
	  Select dropDownOption= new Select(dropDown);
	  dropDownOption.selectByValue("MULTIPLICATION");
	  driver.findElement(By.cssSelector("input[ng-model='second']")).clear();
	  driver.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("3");
	  driver.findElement(By.id("gobutton")).click();
	  Thread.sleep(3000);
	  WebElement result= driver.findElement(By.cssSelector("h2[class='ng-binding']"));
	  String resultText= result.getText();
	  System.out.println("Result="+resultText);
	  st.assertEquals(resultText, "9");
	  st.assertAll();
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
