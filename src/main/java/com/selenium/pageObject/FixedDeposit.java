package com.selenium.pageObject;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
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
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.selenium.pageObject.ListenersCode.class)
public class FixedDeposit {

	//public String url;
	public static WebDriver w;
	public static String projectPath = System.getProperty("user.dir");

	@FindBy(id = "principal")
	public WebElement txtPrincipal;

	@FindBy(name = "interest")
	public WebElement txtInterest;

	@FindBy(css = "input#tenure")
	public WebElement txtTenure;

	@FindBy(name = "tenurePeriod")
	public WebElement dropDrownTenurePeriod;

	@FindBy(id = "frequency")
	public WebElement dropDrownFrequency;

	@FindBy(xpath = "//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement btnCalculate;

	@FindBy(xpath = "//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}

	}

	public void openApplication(String url) {
		w.get(url);
	}

	public void closeBrowser() {

		w.quit();
	}

	public void handleTextBox(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);
	}

	public void handleClickEvent(WebElement we) {

		we.click();
	}

	public String getTextWebElement(WebElement we) {
		return we.getText();
	}
	
	public String getCurrentPageTitle() {
		return w.getTitle();
	}


	public void handleDropDown(WebElement we, String value) {
		Select s = new Select(we);
		s.selectByVisibleText(value);
	}

	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public void handleFrame(WebElement we) {
		w.switchTo().frame(we);
	}

	public void waitSec(int sec) throws Exception {
		sec = sec * 1000;
		Thread.sleep(sec);
	}

	public void takeScreenShot(String fileName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\" + fileName));

	}

	public void exportPageObjectElement() {

		PageFactory.initElements(w, this);
	}
	
	public static String takeScreenShotListenerClass(ITestResult result, String status) throws Exception {

		String ScreenshotName;

		ScreenshotName = result.getMethod().getMethodName() + ".png";

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("passed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Pass\\" + ScreenshotName));
		} else if (status.equalsIgnoreCase("failed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\Fail\\" + ScreenshotName));
		}
		return ScreenshotName;

	}

	public String readdataPropertiesFile(String key) throws Exception {
		
		String configFilePath= System.getProperty("user.dir")+"\\Config\\config.properties";
		FileInputStream fi= new FileInputStream(configFilePath);
		Properties p= new Properties();
		p.load(fi);
		String value= p.getProperty(key);
		fi.close();
		System.out.println("Value returned by property file: "+value);
		return value;
		
	}

}
