package com.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public void writeExcel(String filename, String sheetname,int rownum, int column, String empname, Double empsal) throws IOException
	{
		FileInputStream fs=new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet(sheetname);
		XSSFRow row=sheet.createRow(rownum);
		XSSFCell cell=row.createCell(column);
		cell.setCellValue(empname);
		cell.setCellValue(empsal);
		FileOutputStream fileout=new FileOutputStream(filename);
		wb.write(fileout);
		
		
	}
}
