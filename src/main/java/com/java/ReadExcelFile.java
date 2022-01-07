package com.java;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fw = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleExce.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fw);
		XSSFSheet s = wb.getSheet("sheet1");
		
		for ( Row r : s)
		{
			for ( Cell c : r)
			{
				switch(c.getCellType())
				{
				case STRING : System.out.print(c.getStringCellValue()+" \t");
				break;
				case NUMERIC: System.out.print(c.getNumericCellValue()+ "\t ");
				break;
				default:
					break;
				
				}
				
			}
			System.out.println();
			
		}
		

	}

}

