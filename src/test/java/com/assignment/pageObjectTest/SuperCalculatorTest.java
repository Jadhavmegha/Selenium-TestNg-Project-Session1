package com.assignment.pageObjectTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assignment.pageObject.SuperCalculator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SuperCalculatorTest {
	
	SuperCalculator sc;
	SoftAssert st;
  
  @BeforeTest
  public void beforeTest() {
	  
	  sc= new SuperCalculator();
	  sc.openBrowser("chrome");
	  sc.exportPageObjectElements();
	  st= new SoftAssert();
	  
  }
  
  @Test (priority=0, description="Verify addition")
  public void addition() throws InterruptedException {
	  
	  sc.openApplication();
	  sc.first.clear();
	  sc.first.sendKeys("5");
	  sc.handleDropDown(sc.operator, "+");
	  sc.second.clear();
	  sc.second.sendKeys("5");
	  sc.gobutton.click();
	  sc.waitSec(10);
	  System.out.println("Addition result:"+sc.getResult());
	  st.assertEquals(sc.getResult(), "10");
	  st.assertAll();
	  
  }
  
  @Test (priority=1, description="Verify substraction")
  public void subtraction() throws InterruptedException{
	  
	  sc.openApplication();
	  sc.first.clear();
	  sc.first.sendKeys("3");
	  sc.handleDropDown(sc.operator, "-");
	  sc.second.clear();
	  sc.second.sendKeys("2");
	  sc.gobutton.click();
	  sc.waitSec(1);
	  System.out.println("Addition result:"+sc.getResult());
	  st.assertEquals(sc.getResult(), "1");
	  st.assertAll();
	 
	 
  }

  @AfterTest
  public void afterTest() {
  }

}
