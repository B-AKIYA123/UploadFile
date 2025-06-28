package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
    public static WebDriver  driver;
    public static FileInputStream fi;
	public static XSSFWorkbook book;
	public static String filename;
	public static String sheetname;
	public static int row;
	public static int cell;
	
//	 public static String readDataFromExcel(String filename,String sheetname,int row,int cell) {
//			File f =new File(System.getProperty("user.dir")+"Files\\"+filename+".xlsx");
//			
//			try {
//				fi = new FileInputStream(f);
//			} catch (FileNotFoundException e) {
//			}
//			
//			try {
//				book = new XSSFWorkbook(fi);
//			} catch (IOException e1) {
//			}
//			Sheet sheet = book.getSheet(sheetname);
//			Row row2 = sheet.getRow(row);
//			Cell cell2 = row2.getCell(cell);
			//String cellType = cell2.getStringCellValue();
			//String value = null;
//			if (cellType == 1) {
//				value = cell2.getStringCellValue();
//			}
//			else if (DateUtil.isCellDateFormatted(cell2)) {
//				Date d = cell2.getDateCellValue();
//				SimpleDateFormat s = new SimpleDateFormat("dd-MMMM-YYYY");
//				value = s.format(d);		
//			}
//			else {
//				double d = cell2.getNumericCellValue();
//				long l = (long) d;
//				value = String.valueOf(l);
//				}
//		 return value;
//			return filename;			 
//		}
	 
	public static String main(String[] args) {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();	
//		driver.manage().window().maximize();
//		driver.get("https://accounting.test.acuitysoft.com");
//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
//		WebElement userId = driver.findElement(By.xpath("//*[@id='email']"));
//		Scanner S = new Scanner(System.in);
//		System.out.println("Enter Your Email Id:");
//		String t = S.nextLine();
//		userId.sendKeys(t);				
		int a=1;
		int b=2;
	   if (a<b) {
		   Assert.assertFalse("a is greater than b",false);
		System.out.println("if block running");
	} else {
		System.out.println("else block running");
		Assert.assertTrue("a is not greater than b",false);
	}
	
//		Assert.assertTrue("Check Box is Not Selected",true);  //PASSED
//		Assert.assertTrue("Check Box is Not Selected",false);  //FAILED   
//		
//
//		Assert.assertFalse("Check Box is Not Selected",true); //FAILED
//		Assert.assertFalse("Check Box is Not Selected",false); //PASSED
	File f =new File(System.getProperty("user.dir")+"Files\\"+filename+".xlsx");
	
	try {
		fi = new FileInputStream(f);
	} catch (FileNotFoundException e) {
	}	
	try {
		book = new XSSFWorkbook(fi);
	} catch (IOException e1) {
	}
	Sheet sheet = book.getSheet(sheetname);
	Row row2 = sheet.getRow(row);
	Cell cell2 = row2.getCell(cell);
	return filename;
	
	}
	
}



