package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();


	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
		
		//Count number of radio button on web page.
		
		List<WebElement> radioButton=w.findElements(By.name("radiooptions"));
		int count_radioButton=radioButton.size();
		System.out.println("Radio button count is : "+count_radioButton);
		
		
		
		//Count number of checkbox  on web page.

		List<WebElement> checkbox=w.findElements(By.cssSelector("input[type='checkbox']"));
		int count_checkbox=checkbox.size();
		System.out.println("CheckBox count is : "+count_checkbox);
		
		
		//Count number of Dropdown  on web page.
		
		List<WebElement> Dropdown=w.findElements(By.tagName("select"));
		int count_Dropdown=Dropdown.size();
		System.out.println("Dropdown count is : "+count_Dropdown);
		
		//Count number of links  on web page.
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		int count_links=links.size();
		System.out.println("Links count is : "+count_links);
		
		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {
		
		w.quit();
	}

}
