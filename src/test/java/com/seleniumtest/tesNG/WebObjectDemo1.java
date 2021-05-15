package com.seleniumtest.tesNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class WebObjectDemo1 {
  
	String projectPath;
	WebDriver driver;
	SoftAssert st;
  
  @BeforeTest
  public void preCondition() {
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }
  
  @Test(priority=0, description="Test case to handle TextBox")
  public void textbox() {
	  
	  driver.get("http://demo.automationtesting.in/Register.html");
	  driver.findElement(By.cssSelector("input[placeholder='First Name']")).clear();
	  driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("FirstName1");
	  
	  driver.findElement(By.cssSelector("input[placeholder='Last Name'")).clear();
	  driver.findElement(By.cssSelector("input[placeholder='Last Name'")).sendKeys("LastName1");
	  
  }
  
  @Test(priority=1, description="Test case to handle TextArea(similar to textbox)")
  public void textArea() {
	  

	  driver.findElement(By.cssSelector("textArea[ng-model='Adress']")).clear();
	  driver.findElement(By.cssSelector("textArea[ng-model='Adress']")).sendKeys("A/P: D block");  
	  
  }
  
  @Test(priority=2, description="Test cases to handle radiobuttons")
  
  public void radioButtons() {
	  
	  driver.findElement(By.cssSelector("input[value='Male']")).click();
	  //driver.findElement(By.cssSelector("input[value='FeMale']")).click();  
  }
  
  @Test(priority=3, description="Test cases to handle CheckBOx")
  
  public void checkBox() {
	  
	 driver.findElement(By.id("checkbox1")).click();
	 driver.findElement(By.id("checkbox2")).click();
	 driver.findElement(By.id("checkbox3")).click();  
  }
  

  @Test(priority=4, description="Test cases to handle Dropdown")

 public void dropDown() {
	  
	 WebElement skillsDropDown= driver.findElement(By.cssSelector("select[id='Skills']"));
	 Select st=new Select(skillsDropDown);  // Pass the dropdown list on which we want to work
	 //st.selectByIndex(4);
	 //st.selectByValue("Analytics");
	 st.selectByVisibleText("Java");
	 
 }

  
  @Test(priority=5, description="Test cases to handle ListBOx(similar to click event")

  public void listBox() throws InterruptedException {
 	  
 	 driver.findElement(By.id("msdd")).click();
 	 Thread.sleep(1000);
 	 
 	 driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
 	 Thread.sleep(1000);
 	 
 	driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[3]/a")).click();
	 Thread.sleep(1000);
 	 
  }

  

  @AfterTest
  public void afterTest() {
	  
  }

}
