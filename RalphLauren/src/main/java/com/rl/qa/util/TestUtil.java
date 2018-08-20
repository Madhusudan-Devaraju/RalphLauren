package com.rl.qa.util;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.hssf.usermodel.examples.NewWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;

import com.rl.qa.base.TestBase;


public class TestUtil extends TestBase

{
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITLY_WAIT = 20;

	//	
	//	XSSFSheet sheet;
	//	XSSFWorkbook wb;
	//	
	//	public TestUtil ()
	//	{
	//		try 
	//		{
	//			String excelPath = "E:\\rl.xlsx";
	//			File src = new File (excelPath);
	//			FileInputStream fis = new FileInputStream(src);
	//			wb = new XSSFWorkbook(fis);
	//		} 
	//		catch (IOException e) 
	//		{
	//			System.out.println(e.getMessage());
	//		}
	//	}
	//
	//	public String getData(int sheetnumber, int row, int column)
	//	{
	//		sheet = wb.getSheetAt(sheetnumber);
	//		String data = sheet.getRow(row).getCell(column).getStringCellValue();
	//		return data;
	//	}

	public static String TESTDATA_SHEET_PATH = "E:\\RLGit\\RalphLauren\\src\\main\\java\\com\\rl\\qa\\testdata\\rl.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		}
		return data;
	}
	
	public static void takeScreenShot() throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new  File(currentDir+ "/screenshots/"+System.currentTimeMillis()+ ".png"));
	}

}