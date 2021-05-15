package com.seleniumtest.tesNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SampleTest1 {
 
  @BeforeTest
  public void beforeTest() {
  }
  
  @Test (priority=0, description="method1")
  public void m1() {
	  System.out.println("method1 run");
  }
  
  @Test (priority=1, description="method2",dependsOnMethods="m1",groups="grp1",enabled=false)
  public void m2() {
	  System.out.println("method2 run");
  }
  
  @Test (priority=2, description="method3")
  public void m3() {
	  System.out.println("method3 run");
  }
  
  
  @Test (priority=3, description="method4")
  public void m4() {
	  System.out.println("method4 run");
  }

  @AfterTest
  public void afterTest() {
  }

}
