package genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibraryCRM {
public String getPropertyValue(String propPath,String key) throws Throwable 
{
	FileInputStream fis=new FileInputStream(propPath);
	Properties prop=new Properties();
	prop.load(fis);
	String propValue = prop.getProperty(key, "key not found");
	return propValue;
}
public String getCellData(String excelPath,String sheet,int r,int c) throws Throwable {
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	String exelvalue = wb.getSheet(sheet).getRow(r).getCell(c).toString();
	return exelvalue;
	
}
public int getRowCount(String excelPath,String sheet) throws Throwable {
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount=wb.getSheet(sheet).getLastRowNum();
	return rowCount;
	
}
public void setCellData(String excelPath,String sheet,int r,int c,String data) throws Throwable {
	FileInputStream fis=new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheet).getRow(r).createCell(c).setCellValue(data);
	FileOutputStream fos=new FileOutputStream(excelPath);
	wb.write(fos);
	wb.close();
	
	
}
}
