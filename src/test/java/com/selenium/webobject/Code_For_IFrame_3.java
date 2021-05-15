package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{
		
		w.get("https://groww.in/calculators/emi-calculator/");
		
		/***** handling frame code ******/
		
	//	WebElement iframe=w.findElement(By.cssSelector("iframe[data-lazy-type='iframe']"));		
	//	w.switchTo().frame(iframe);
		
		
		w.findElement(By.id("inputAmount")).clear();
		w.findElement(By.id("inputAmount")).sendKeys("400000");
		
		w.findElement(By.id("inputRoi")).clear();
		w.findElement(By.id("inputRoi")).sendKeys("9");

		w.findElement(By.id("inputYears")).clear();
		w.findElement(By.id("inputYears")).sendKeys("8");
		
	}

	@AfterTest
	public void afterTest() {
	//	w.quit();
	}

}
