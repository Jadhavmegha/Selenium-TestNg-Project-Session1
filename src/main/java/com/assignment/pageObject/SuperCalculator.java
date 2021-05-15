package com.assignment.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuperCalculator {

	WebDriver driver;
	String url="https://juliemr.github.io/protractor-demo/";
	//int output;
	
	@FindBy(css="input[ng-model='first']")
	public WebElement first;
	
	@FindBy(css="input[ng-model='second']")
	public WebElement second;
	
	@FindBy (css="select[ng-model='operator']")
	public WebElement operator;
	
	@FindBy(id="gobutton")
	public WebElement gobutton;
	
	@FindBy(xpath="/html/body/div/div/form/h2")
	public WebElement result;
	
	public void openBrowser(String browser)
	{
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		}
		
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		}
	}
	
	public void openApplication()
	{
		driver.get(url);
	}
	
	public void waitSec(int sec) throws InterruptedException
	{
		sec=sec*1000;
		Thread.sleep(sec);
	}
	
	public void handleDropDown(WebElement w, String value)
	{
		Select s= new Select(w);
		s.selectByVisibleText(value);
	}
	
	public void exportPageObjectElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getResult()
	{
		
		return result.getText();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
