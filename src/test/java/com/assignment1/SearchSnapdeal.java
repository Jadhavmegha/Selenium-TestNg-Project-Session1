package com.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchSnapdeal {

	public static void main(String[] args) {
		
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//driver.switchTo().newWin
		Actions a= new Actions(driver);
		a.sendKeys(Keys.CONTROL+"T");
		
		/*driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Snapdeal", Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@class=\"ruhjFe NJLBac fl\"]")).click();
		
		driver.findElement(By.linkText("View history")).click();*/
		//driver.close();
	

	}

}
