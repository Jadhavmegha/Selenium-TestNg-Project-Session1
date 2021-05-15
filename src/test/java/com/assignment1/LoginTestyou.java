package com.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestyou {

	public static void main(String[] args) throws InterruptedException {
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//1 Open URL
		driver.get("http://www.testyou.in/Login.aspx");
		
		driver.manage().window().maximize();
		
		//2.Enter user name
		driver.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
		driver.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
		driver.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
		driver.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
		Thread.sleep(3000);
		driver.quit();
		//driver.getTitle();
		
	}

}
