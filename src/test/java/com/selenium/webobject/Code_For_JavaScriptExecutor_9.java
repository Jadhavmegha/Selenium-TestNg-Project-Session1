package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_JavaScriptExecutor_9 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void Code_For_JavaScriptExecutor_Test() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");

		WebElement firstName = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
		WebElement lastName = w.findElement(By.cssSelector("input[ng-model='LastName']"));

		JavascriptExecutor js = (JavascriptExecutor) w;
		
		// JavascriptExecutor for input

		js.executeScript("arguments[0].value=''", firstName);
		js.executeScript("arguments[0].value='Jones'", firstName);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value=''", lastName);
		js.executeScript("arguments[0].value='Smith'", lastName);
		
		Thread.sleep(2000);

		//Page Down
		js.executeScript("window.scrollBy(0,600)");
		
	
		Thread.sleep(2000);

		
		//Listbox
		w.findElement(By.id("msdd")).click();
		Thread.sleep(2000);
		
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]")).click();
		Thread.sleep(2000);
		
		WebElement thai=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[37]"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", thai);


		thai.click();
		
		//Select data from drop-sown list
		Thread.sleep(2000);
		WebElement skillsDropDown= w.findElement(By.id("Skills"));

		Select sel = new Select(skillsDropDown);
		sel.selectByVisibleText("Java"); // actual text from drop down
	}

	@AfterTest
	public void afterTest() {
	}

}
