package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Alert_2 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_Alert_Test() throws Exception {
		
		w.get("https://demo.testfire.net/login.jsp");
        w.findElement(By.id("uid")).sendKeys("1");
        w.findElement(By.name("btnSubmit")).click();
        Thread.sleep(2000);
        
        w.switchTo().alert().accept();
        
        Thread.sleep(2000);
        
        w.findElement(By.id("uid")).clear();
        w.findElement(By.id("uid")).sendKeys("admin");
        w.findElement(By.id("passw")).clear();
        w.findElement(By.id("passw")).sendKeys("admin");
        w.findElement(By.name("btnSubmit")).click();
        Thread.sleep(3000);
        w.findElement(By.linkText("Sign Off")).click();
        Thread.sleep(2000);

        
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
