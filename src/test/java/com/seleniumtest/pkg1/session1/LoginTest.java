package com.seleniumtest.pkg1.session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		// Step 1: Open application
		driver.get("http://demo.testfire.net/login.jsp");
		
		//Step 2: Enter username
		driver.findElement(By.id("uid")).sendKeys("admin");
		
		//Step 3: Enter password
		driver.findElement(By.id("passw")).sendKeys("admin");
		
		//Step 4: Click on login button
		driver.findElement(By.name("btnSubmit")).click();
		
		//Step 4: Click logout
		driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		// Step 5 Close browser
		driver.quit();

	}

}
