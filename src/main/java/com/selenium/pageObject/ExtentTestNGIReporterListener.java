package com.selenium.pageObject;


import java.util.*;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGIReporterListener implements IReporter {
    
    private static final String OUTPUT_FOLDER = FixedDeposit.projectPath + "\\ExtentReport\\";
    private static final String FILE_NAME = "Extent.html";
    
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        init();
        
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                
                try {
					buildTestNodes(context.getFailedTests(), Status.FAIL);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getSkippedTests(), Status.SKIP);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getPassedTests(), Status.PASS);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        }
        
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }
        
        extent.flush();
    }
    
    private void init() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setSystemInfo("Automation Tool", "Selenium");
        extent.setSystemInfo("Selenium version", "3.141.59");
        extent.setSystemInfo("Prgramming Langauge", "Java");
        extent.setSystemInfo("Java version", "8");

    }
    
    private void buildTestNodes(IResultMap tests, Status status) throws Exception {
        ExtentTest test;
        
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getDescription());
                
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                    
                    String screenShotPathFail=FixedDeposit.projectPath+"\\Screenshot\\Fail\\";
                	MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenShotPathFail+"\\"+FixedDeposit.takeScreenShotListenerClass(result, "fail")).build();
                			test.fail("Below Sreenshot", mediaModel);	
                	
                }
                else {
                	
                	  String screenShotPathPass=FixedDeposit.projectPath+"\\Screenshot\\Pass\\";
                  	MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(screenShotPathPass+"\\"+FixedDeposit.takeScreenShotListenerClass(result, "pass")).build();
                  			test.pass("Below Sreenshot", mediaModel);	
                  	
                	
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }
    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();      
    }
}