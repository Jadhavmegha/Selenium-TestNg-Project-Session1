package com.selenium.datadriven;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExelFile {

	public static void main(String[] args) throws IOException {
		
		String excelFilePath= System.getProperty("user.dir")+"\\TestData\\FDCal.xlsx";
		
		DataFormatter df= new DataFormatter();
		FileInputStream fi= new FileInputStream(excelFilePath);
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet sheet= wb.getSheet("Sheet1");
		XSSFRow row= sheet.getRow(2);
		XSSFCell cell= row.getCell(0);
		wb.close();
		String cellValue= df.formatCellValue(cell);
		
		System.out.println(cellValue);
		
		

	}

}
