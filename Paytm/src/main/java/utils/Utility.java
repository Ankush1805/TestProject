package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility{
	
	public static void captureScreen(WebDriver driver, int testID)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date = new Date();
		String d = formatter.format(date);
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File ("test-output\\testScreenshots\\Test"+d+".jpg");
		
		try
		{
			FileHandler.copy(src, dest);
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	public static String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		String path = "src\\test\\resources\\testData\\TestData.xlsx" ;
		FileInputStream file = new FileInputStream(path);
		Cell c = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);
		
		String cellvalue = "" ;
		
		try
		{
			cellvalue = c.getStringCellValue();
		}
		
		catch(IllegalStateException ise)
		{
			Double numCellValue = c.getNumericCellValue();
			
			cellvalue = Double.toString(numCellValue);
		}
		
		catch (NullPointerException npe) 
		{
			npe.printStackTrace();
			npe.getMessage();
		}
		
		return cellvalue;
	}
	
	
	
	
	
	
	
	
	
	
	

}
