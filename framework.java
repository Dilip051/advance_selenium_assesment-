package com.selenium_assesment.selenium_assesment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class framework {
	@DataProvider(name="Dilip")
	public Object[][] readdata() throws InvalidFormatException, IOException {
		Object[][] data=null;
//		1.to take file path
		String filepath="C:\\selenium\\framwork.xlsx";
//		2.to make file;        
		
		File file=new File(filepath);  
//		3.to open particular excel file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
//		4.to open sheet(note : here always select Sheet option second - ss )
		Sheet sheet=workbook.getSheet("Sheet3");
//		get size of row
		int nrow=sheet.getPhysicalNumberOfRows();
//		initialize
		data=new Object[nrow][];
		for (int i = 0; i < data.length; i++) {
//			5. select a particular row
			Row row=sheet.getRow(i);
			int ncell=row.getPhysicalNumberOfCells();
			data[i]=new Object[ncell];
			
			for (int j = 0; j < data[i].length; j++) {
//	      6. select particular cell
				Cell cell=row.getCell(j);
//			7. to set all cell type to string
				cell.setCellType(CellType.STRING);
//			8.to get data from the cell
				data[i][j]=cell.getStringCellValue();
			}
			}
		return data;
	}
	
	WebDriver driver1;
	@Test(dataProvider = "Dilip")
	public void test(String keyword,String data) throws InvalidFormatException, IOException, InterruptedException {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		 
	if (keyword.equals("open browser")) {
		driver1=new ChromeDriver(); 
	}
	else if (keyword.equals("open url")) {
		driver1.get(data);
		Thread.sleep(2000);
		
	}
	else if (keyword.equals("enter username")) {
		driver1.findElement(By.id("user-name")).sendKeys(data);
		Thread.sleep(2000);
	}
	else if (keyword.equals("enter password")) {
		driver1.findElement(By.id("password")).sendKeys(data);
		Thread.sleep(2000);
	
	}
	else if (keyword.equals("click login")) {

		driver1.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		driver1.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		
		driver1.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);
	
			driver1.close();
	}
			
	
				
		}		
}
