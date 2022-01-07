package com.java;

import java.io.FileOutputStream;

import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("sheet1");
		
		Row r0 = sheet.createRow(0);
		Cell c00 = r0.createCell(0);
		c00.setCellValue("Swapna");
		Cell c01 = r0.createCell(1);
		c01.setCellValue("Nihal");
		Cell c02 = r0.createCell(2);
		c02.setCellValue("Nirvan");
		
		Row r1 = sheet.createRow(1);
		Cell c10 = r1.createCell(0);
		c10.setCellValue(38);
		Cell c11 = r1.createCell(1);
		c11.setCellValue(8);
		Cell c12 = r1.createCell(2);
		c12.setCellValue(2);
		
		
		FileOutputStream fw = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleExce.xlsx");
		workBook.write(fw);
		
		
		workBook.close();
		fw.close();
		
		

	}

}
