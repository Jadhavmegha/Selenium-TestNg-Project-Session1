package com.selenium.pageObject;

import java.io.File;
//import java.io.IOException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositFromSir {

	public String url = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";
	public WebDriver w;
	public String projectPath = System.getProperty("user.dir");

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
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
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

	public void openApplication() {
		w.get(url);
	}

	public void closeBrowser() {

		w.quit();
	}

	public void handleTextBox(WebElement we, String value) {

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

		TakesScreenshot ts = (TakesScreenshot) w;  //Press PrtScr
		File f = ts.getScreenshotAs(OutputType.FILE); // Convert to file
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\" + fileName)); //Save file

	}

	public void exportPageObjectElement() {

		PageFactory.initElements(w, this);
	}

}
