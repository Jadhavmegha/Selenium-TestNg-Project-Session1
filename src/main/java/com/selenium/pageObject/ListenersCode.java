package com.selenium.pageObject;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersCode implements ITestListener {

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Case Passed : " + result.getMethod().getDescription());
		
		try {
			FixedDeposit.takeScreenShotListenerClass(result, "passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getName());
	
		try {
			FixedDeposit.takeScreenShotListenerClass(result, "failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getName());

		
	}

}
