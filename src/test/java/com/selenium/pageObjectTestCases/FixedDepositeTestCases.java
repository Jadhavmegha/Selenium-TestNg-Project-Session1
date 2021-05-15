package com.selenium.pageObjectTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.selenium.pageObject.FixedDeposite_WithoutPropertyFile;

public class FixedDepositeTestCases {
	
	FixedDeposite_WithoutPropertyFile fd;
  
  @BeforeTest
  public void beforeTest() {
	  
	  fd= new FixedDeposite_WithoutPropertyFile();
	  fd.openBrowser("chrome");
	 fd.exportPageObjectElement();
	  
  }
  
  @Test
  public void calculateFD_100000() throws InterruptedException {
	  
	 fd.openApplication();
	 fd.txtPrincipal.sendKeys("100000");
	 fd.txtInterest.sendKeys("9");
	 fd.txtTenure.sendKeys("2");
	 fd.handleDropDown(fd.dropDrownTenurePeriod, "1");
	 fd.handleDropDown(fd.dropDrownFrequency, "0");
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  
	  fd.waitSec(3);
	  fd.closeBrowser();
  }

}
