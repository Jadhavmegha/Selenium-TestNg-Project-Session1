package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_MouseHandle_7 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_MouseHandle_Test() throws Exception {

	/*	w.get("https://www.ebay.com/");		
		w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		
		w.navigate().back();
		
		Thread.sleep(2000);

		
		WebElement Electronics=w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		
		Actions a=new Actions(w);
		a.moveToElement(Electronics).build().perform();
		
		Thread.sleep(2000);
		w.findElement(By.xpath("//a[text()='Apple']")).click();
		
		Thread.sleep(2000);

		//Right click

		WebElement Apple_Cell_Phones_Smartphones=w.findElement(By.xpath("//*[@id=\"s0-16-13_2-0-1[0]-0-0\"]/ul/li[2]/a"));
        a.moveToElement(Apple_Cell_Phones_Smartphones).contextClick().build().perform();
        
        */
		
	/*	w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
		
		WebElement draggable=w.findElement(By.id("draggable"));
		WebElement droppable=w.findElement(By.id("droppable"));

		Actions drag_drop=new Actions(w);
		drag_drop.dragAndDrop(draggable, droppable).build().perform();
		*/
		
	}

	@AfterTest
	public void afterTest() {
	}
}
