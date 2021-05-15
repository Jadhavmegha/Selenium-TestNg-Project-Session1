package com.assignment.pageObjectTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageObject.FixedDeposit;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;



import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageObject.ListenersCode.class)

public class FixedDepositTestCaseExtentReport {

	FixedDeposit fd;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDeposit();
		fd.openBrowser(fd.readdataPropertiesFile("browser"));
		fd.exportPageObjectElement();

		extentHtmlReporter = new ExtentHtmlReporter(FixedDeposit.projectPath + "\\ExtentReport\\FD_Report.html");
		extentHtmlReporter.config().setDocumentTitle("Fixed Deposit Report");
		extentHtmlReporter.config().setReportName("Fixed Deposit Test");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Automation Tool", "Selenium");
		extentReports.setSystemInfo("Selenium version", "3.141.59");
		extentReports.setSystemInfo("Prgramming Langauge", "Java");
		extentReports.setSystemInfo("Java version", "8");

	}

	@Test(priority = 0, description = "Test case to verify fixed deposit for '100000'")
	public void fd_100000() throws Exception {

		extentTest = extentReports.createTest("Fixed Deposit for 1 lakh");

		fd.openApplication(fd.readdataPropertiesFile("url_fd"));

		fd.handleTextBox(fd.txtPrincipal, "100000");
		fd.handleTextBox(fd.txtInterest, "8");
		fd.handleTextBox(fd.txtTenure, "2");

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, "Simple Interest");

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

		// System.out.println("Maturity Value : " +
		// fd.getTextWebElement(fd.maturityValue));
//		System.out.println("Page Title is : " + fd.getCurrentPageTitle());

	}

	@Test(priority = 1, description = "Test case to verify fixed deposit for '200000'")
	public void fd_200000() throws Exception {

		extentTest = extentReports.createTest("Fixed Deposit for 2 lakh");

		fd.openApplication(fd.readdataPropertiesFile("url_fd"));

		fd.handleTextBox(fd.txtPrincipal, "200000");
		fd.handleTextBox(fd.txtInterest, "9");
		fd.handleTextBox(fd.txtTenure, "4");

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, "Simple Interest");

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

		System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));

	}

	@Test(priority = 2, description = "Test case to verify fixed deposit for '300000'")
	public void fd_300000() throws Exception {

		extentTest = extentReports.createTest("Fixed Deposit for 3 lakh");

		fd.openApplication(fd.readdataPropertiesFile("url_fd"));

		fd.handleTextBox(fd.txtPrincipal, "300000");
		fd.handleTextBox(fd.txtInterest, "8.5");
		fd.handleTextBox(fd.txtTenure, "3");

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, "Simple Interest");

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

		System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));

	}

	@AfterMethod
	public void updateExtentReport(ITestResult result) throws Exception {
		
		String screenShotPathPass=FixedDeposit.projectPath+"\\Screenshot\\Pass\\";
		String screenShotPathFail=FixedDeposit.projectPath+"\\Screenshot\\Fail\\";


		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getMethod().getDescription());
			
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenShotPathPass+"\\"+FixedDeposit.takeScreenShotListenerClass(result, "passed")).build();
			extentTest.pass("details", mediaModel);	
			
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getMethod().getDescription());
			
			MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenShotPathFail+"\\"+FixedDeposit.takeScreenShotListenerClass(result, "failed")).build();
			extentTest.fail("details", mediaModel);	
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getMethod().getDescription());
		}
		
		extentReports.flush();
		//extent report .html file will not get created

	}

	@AfterTest
	public void afterTest() {

		fd.closeBrowser();
	}

}
