package com.seleniumtest.tesNG;
import org.testng.annotations.Test;
import com.selenium.pageObject.FixedDepositFromSir;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FixedDepositeTestCases {

	FixedDepositFromSir fd;

	@BeforeTest
	public void beforeTest() {

		fd = new  FixedDepositFromSir();
		fd.openBrowser("chrome");
		fd.exportPageObjectElement();

	}

	@Test(priority = 0, description = "Test case to verify fixed deposit for '100000'")
	public void fd_100000() throws Exception {

		fd.openApplication();

		fd.handleTextBox(fd.txtPrincipal, "100000");
		fd.handleTextBox(fd.txtInterest, "8");
		fd.handleTextBox(fd.txtTenure, "2");

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, "Simple Interest");

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

		System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));
		System.out.println("Page Title is : " + fd.getCurrentPageTitle());

		fd.takeScreenShot("fd_100000.png");

	}

	@Test(priority = 1, description = "Test case to verify fixed deposit for '200000'")
	public void fd_200000() throws Exception {

		fd.openApplication();

		fd.handleTextBox(fd.txtPrincipal, "200000");
		fd.handleTextBox(fd.txtInterest, "9");
		fd.handleTextBox(fd.txtTenure, "4");

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, "Simple Interest");

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

		System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));

		fd.takeScreenShot("fd_200000.png");

	}

	@AfterTest
	public void afterTest() {

		fd.closeBrowser();
	}

}
