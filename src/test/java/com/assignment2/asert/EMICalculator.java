package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class EMICalculator {
	
	String projectPath;
	WebDriver driver;
	SoftAssert st;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }
  
  @Test (priority=0, description="Verify for 100000")
  public void scenario1() {
	  st=new SoftAssert();
	  driver.get("https://www.business-standard.com/personal-finance/financial-tools/emi-calculator");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.cssSelector("input#amount")).sendKeys("100000");
	  driver.findElement(By.xpath("//input[@id='years']")).sendKeys("2");
	  driver.findElement(By.cssSelector("input#rate")).sendKeys("9");
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  WebElement loanAmount= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[1]/td[2]"));
	  String loanAmountValue=loanAmount.getText();
	  System.out.println("Loan amount="+loanAmountValue);
	  st.assertEquals(loanAmountValue, "100000");
	  
	  String periods= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[2]/td[2]")).getText();
	  System.out.println("Periods="+periods);
	  st.assertEquals(periods, "2");
	  
	  String rate= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[3]/td[2]")).getText();
	  System.out.println("Rate of interest="+rate);
	  st.assertEquals(rate, "9");
	  
	  String EMI= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[4]/td[2]")).getText();
	  System.out.println("EMI amount="+EMI);
	  st.assertEquals(EMI, "4,568.47");
	  
	  st.assertAll();
  }
  
  @Test (priority=1, description="Verify for 400000")
  public void scenario2() {
	  st=new SoftAssert();
	  driver.get("https://www.business-standard.com/personal-finance/financial-tools/emi-calculator");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.cssSelector("input#amount")).sendKeys("400000");
	  driver.findElement(By.xpath("//input[@id='years']")).sendKeys("4");
	  driver.findElement(By.cssSelector("input#rate")).sendKeys("6");
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  WebElement loanAmount= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[1]/td[2]"));
	  String loanAmountValue=loanAmount.getText();
	  System.out.println("Loan amount="+loanAmountValue);
	  st.assertEquals(loanAmountValue, "400000");
	  
	  String periods= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[2]/td[2]")).getText();
	  System.out.println("Periods="+periods);
	  st.assertEquals(periods, "4");
	  
	  String rate= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[3]/td[2]")).getText();
	  System.out.println("Rate of interest="+rate);
	  st.assertEquals(rate, "6");
	  
	  String EMI= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[4]/td[2]")).getText();
	  System.out.println("EMI amount="+EMI);
	  st.assertEquals(EMI, "9,394.01");
	  
	  st.assertAll();
  }
  
  @Test (priority=2, description="Verify for 800000")
  public void scenario3() {
	  st=new SoftAssert();
	  driver.get("https://www.business-standard.com/personal-finance/financial-tools/emi-calculator");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.cssSelector("input#amount")).sendKeys("800000");
	  driver.findElement(By.xpath("//input[@id='years']")).sendKeys("2");
	  driver.findElement(By.cssSelector("input#rate")).sendKeys("10");
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  
	  WebElement loanAmount= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[1]/td[2]"));
	  String loanAmountValue=loanAmount.getText();
	  System.out.println("Loan amount="+loanAmountValue);
	  st.assertEquals(loanAmountValue, "800000");
	  
	  String periods= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[2]/td[2]")).getText();
	  System.out.println("Periods="+periods);
	  st.assertEquals(periods, "2");
	  
	  String rate= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[3]/td[2]")).getText();
	  System.out.println("Rate of interest="+rate);
	  st.assertEquals(rate, "10");
	  
	  String EMI= driver.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]/table/tbody/tr[4]/td[2]")).getText();
	  System.out.println("EMI amount="+EMI);
	  st.assertEquals(EMI, "36,915.94");
	  
	  st.assertAll();
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  
  }

}
