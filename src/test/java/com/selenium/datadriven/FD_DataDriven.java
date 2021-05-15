package com.selenium.datadriven;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.pageObject.FixedDeposit;



import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;

import java.io.FileInputStream;
//import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.Reporter;
import org.testng.annotations.AfterTest;

//@Listeners(com.selenium.report.ListenersCode.class)

public class FD_DataDriven {

	FixedDeposit fd;
	String excelFilePath;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cellPrinciple, cellInterest, cellPeriod, cellFrequency, cellMaturity;
	SoftAssert sa;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDeposit();
		fd.openBrowser(fd.readdataPropertiesFile("browser"));
		fd.exportPageObjectElement();

		df = new DataFormatter();
		excelFilePath = System.getProperty("user.dir") + "\\TestData\\FDCal.xlsx";
		fi = new FileInputStream(excelFilePath);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet("Sheet1");
		

	}

	@Test(priority = 0, description = "Test case to verify fixed deposit for multiple data", groups = "Fixed Deposit")
	public void fd_DataDriven() throws Exception {

		int rowCount = sheet.getLastRowNum();
		System.out.println("Number of rows : " + rowCount);

		for (int i = 1; i <= rowCount; i++) // i -> rows
		{
			int j = 0;// j -> cells / columns

			row = sheet.getRow(i);

			cellPrinciple = row.getCell(j);
			cellInterest = row.getCell(j + 1);
			cellPeriod = row.getCell(j + 2);
			cellFrequency = row.getCell(j + 3);
			cellMaturity=row.getCell(j+4);
			String principleValue = df.formatCellValue(cellPrinciple);
			String interestValue = df.formatCellValue(cellInterest);
			String periodValue = df.formatCellValue(cellPeriod);
			String frequencyValue = df.formatCellValue(cellFrequency);
			String maturityValue= df.formatCellValue(cellMaturity);
			fd.openApplication(fd.readdataPropertiesFile("url_fd"));

			fd.handleTextBox(fd.txtPrincipal, principleValue);
			fd.handleTextBox(fd.txtInterest, interestValue);
			fd.handleTextBox(fd.txtTenure, periodValue);

			fd.handleDropDown(fd.dropDrownTenurePeriod, "year(s)");
			fd.handleDropDown(fd.dropDrownFrequency, frequencyValue);

			fd.handleClickEvent(fd.btnCalculate);

			fd.waitSec(2);
			
			System.out.println("Maturity Amount : " + fd.maturityValue.getText());
		}
	}

	@AfterTest
	public void afterTest() throws Exception {

		fd.closeBrowser();
		wb.close();
		fi.close();
	}

}
