package com.selenium.datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

import com.selenium.pageObject.FixedDeposite_WithoutPropertyFile;

public class FD_DataDrivenTestCases {
	
	FixedDeposite_WithoutPropertyFile fd;
	String excelFilePath;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cellPrincipal, cellInterest, cellPeriod, cellFrequency;
	
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  fd= new FixedDeposite_WithoutPropertyFile();
	  fd.openBrowser("chrome");
	 fd.exportPageObjectElement();
	 
	 // Data Driver things
	 excelFilePath= System.getProperty("user.dir")+"\\TestData\\FDCal.xlsx";
	 df= new DataFormatter(); // To convert excel float data to integer
	 fi= new FileInputStream(excelFilePath);
	 wb= new XSSFWorkbook(fi);
	 sheet= wb.getSheet("Sheet1"); 
	  
  }
  
  @Test
  public void calculateFD_100000() throws InterruptedException {
	  
	 fd.openApplication();
	 int rowCount= sheet.getLastRowNum();
	 System.out.println(rowCount);
	 for(int i=1;i<=rowCount;i++)
	 {
		 row= sheet.getRow(i);
		 int j=0;
		 cellPrincipal=row.getCell(j);
		 cellInterest=row.getCell(j+1);
		 cellPeriod=row.getCell(j+2);
		 cellFrequency=row.getCell(j+3);
	 
	 
	 String principalValue=df.formatCellValue(cellPrincipal);
	 String interestValue=df.formatCellValue(cellInterest);
	 String periodValue=df.formatCellValue(cellPeriod);
	 String frequencyValue=df.formatCellValue(cellFrequency);
	 
	 fd.txtPrincipal.sendKeys(principalValue);
	 fd.txtInterest.sendKeys(interestValue);
	 fd.txtTenure.sendKeys(periodValue);
	 fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
	 fd.handleDropDown(fd.dropDrownFrequency, frequencyValue);
	 fd.btnCalculate.click();
	 System.out.println("Maturity Value : " + fd.getTextWebElement(fd.maturityValue));
	 fd.waitSec(10);
	 }
  }

  @AfterTest
  public void afterTest() throws Exception{
	  
	  
	  fd.closeBrowser();
	  wb.close();
	  fi.close();
	  
  }

}
