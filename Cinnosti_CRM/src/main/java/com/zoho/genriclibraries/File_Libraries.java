package com.zoho.genriclibraries;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Libraries {
	
	public String getKeyPropVlaue(String propPath,String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String propVlaue = prop.getProperty(key,"KEY NOT FOUND");
		return propVlaue;	
	}
	public int getRowCount(String excelpath,String sheet) throws Throwable
	{
		FileInputStream fis =new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount= wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	public String getCellData(String excelPath,String sheet,int r,int c) throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String cellValue=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		return cellValue;
	}
	
}
