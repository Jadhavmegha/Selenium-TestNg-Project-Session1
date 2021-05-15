package com.selenium.pageObject;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDeposite_WithoutPropertyFile {
	
	// This class stores all the webelements + methods
	
	public static WebDriver driver;
	public static String url="https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";
	public static String projectPath=System.getProperty("user.dir");
	
	@FindBy(id="principal")
	public WebElement txtPrincipal;
	
	@FindBy(id="interest")
	public WebElement txtInterest;
	
	@FindBy(name="tenure")
	public WebElement txtTenure;
	
	@FindBy(name = "tenurePeriod")
	public WebElement dropDrownTenurePeriod;
	
	
	@FindBy(id="frequency")
	public WebElement dropDrownFrequency;
	
	@FindBy(xpath="//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement btnCalculate;
	
	@FindBy(xpath = "//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;
	
	
	public void openBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
	
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void openApplication()
	{
		driver.get(url);
	}
	
	public void handleTextBox(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);
	}
	
	public void handleClickEvent(WebElement we) {

		we.click();
	}
	
	public void handleDropDown(WebElement we, String value)
	{
		Select s= new Select(we);
		s.selectByVisibleText(value);
	}
	
	public String getTextWebElement(WebElement we) {
		return we.getText();
	}
	
	public void waitSec(int sec) throws InterruptedException
	{
		sec= sec*1000;
		Thread.sleep(sec);
	}
	
	public void exportPageObjectElement()
	{
		PageFactory.initElements(driver, this);
		// OR PageFactory.initElements(driver, FixedDeposite.class);
	}
	
	public void takeScreenShot(String fileName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;  //Press PrtScr
		File f = ts.getScreenshotAs(OutputType.FILE); // Convert to file
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\" + fileName)); //Save file

	}
	
	public static String takeScreenShotListenerClass(ITestResult result, String status) throws Exception {

		String ScreenshotName;

		ScreenshotName = result.getMethod().getMethodName() + ".png";

		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("passed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Pass\\" + ScreenshotName));
		} else if (status.equalsIgnoreCase("failed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Fail\\" + ScreenshotName));
		}
		return ScreenshotName;

	}
	
	
		
	}
