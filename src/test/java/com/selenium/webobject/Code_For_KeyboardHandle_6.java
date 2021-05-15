package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_KeyboardHandle_6 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_KeyboardHandle_Test() throws Exception {
		
		Actions a=new Actions(w);
		
		w.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		WebElement firstName = w.findElement(By.id("firstName"));
		firstName.clear();
		firstName.sendKeys("JonesP");	
		
		Thread.sleep(2000);
		firstName.sendKeys(Keys.BACK_SPACE);		
		Thread.sleep(2000);
		
		a.sendKeys(Keys.TAB).build().perform();		
		
		
		WebElement lastName = w.findElement(By.name("lastName"));
		lastName.sendKeys("Smith");		
		
		Thread.sleep(2000);
		a.sendKeys(Keys.TAB).build().perform();	
		
		
		Thread.sleep(2000);
		a.sendKeys(Keys.ENTER).build().perform();	
		
		
		
	}

	@AfterTest
	public void afterTest() {
	}

}
