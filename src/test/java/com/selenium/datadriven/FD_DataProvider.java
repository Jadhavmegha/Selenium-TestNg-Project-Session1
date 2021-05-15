package com.selenium.datadriven;

import org.testng.annotations.Test;

import com.selenium.pageObject.FixedDeposit;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;




public class FD_DataProvider {

	FixedDeposit fd;
	
	@DataProvider
	public Object[][] dp(){
		return new Object [][] {
			new Object [] {"100000", "8","3", "Simple Interest"},
			new Object [] {"200000", "2","1", "Simple Interest"},
			new Object [] {"400000", "9","4", "Simple Interest"},
			new Object [] {"800000", "2","2", "Simple Interest"},
		};
		}
	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDeposit();
		fd.openBrowser("chrome");
		fd.exportPageObjectElement();

	}

	@Test(dataProvider="dp")
	public void fd_DataProvider(String principle, String interest, String period, String frequency) throws Exception {

		fd.openApplication(fd.readdataPropertiesFile("url_fd"));
		fd.handleTextBox(fd.txtPrincipal, principle);
		fd.handleTextBox(fd.txtInterest, interest);
		fd.handleTextBox(fd.txtTenure, period);

		fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
		fd.handleDropDown(fd.dropDrownFrequency, frequency);

		fd.handleClickEvent(fd.btnCalculate);

		fd.waitSec(2);

	System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));
//		System.out.println("Page Title is : " + fd.getCurrentPageTitle());
	
		
		
	}

	


	@AfterTest
	public void afterTest() {

		//fd.closeBrowser();
	}

}
