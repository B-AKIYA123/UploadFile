package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.symmetric.ChaCha.BaseCC20P1305;

public class Test extends BaseClass {
	 

     // Determine the start and end months of the current quarter
     
	public static void main(String[] args) throws Throwable {
		System.out.println(System.getProperty("user.dir"));
		System.err.println(System.getProperty("user.home"));
		
		
//		double s = 180.0+0;
//		
//		String str=Double.toString(s);	
//		String t = str+0;
//		System.out.println(t);
//		
//		System.out.println(readDataFromExcelcom2("Credentials", "Sheet1", 1, 2));
//		System.out.println(readDataFromExcelcom2("Credentials", "Sheet1", 1, 2));
		
		System.out.println(readDataFromExcelcom2("Sheet1", 1, 4));	
		
		LocalDate today = LocalDate.now();
		LocalDate startOfQuarter;
	     LocalDate endOfQuarter;
		Month currentMonth = today.getMonth();
	       if (currentMonth.getValue() <= 3) {
	           // Q1: January - March
	           startOfQuarter = LocalDate.of(today.getYear(), Month.JANUARY, 1);
	           endOfQuarter = LocalDate.of(today.getYear(), Month.MARCH, Month.MARCH.length(today.isLeapYear()));
	       } else if (currentMonth.getValue() <= 6) {
	           // Q2: April - June
	           startOfQuarter = LocalDate.of(today.getYear(), Month.APRIL, 1);
	           endOfQuarter = LocalDate.of(today.getYear(), Month.JUNE, Month.JUNE.length(today.isLeapYear()));
	       } else if (currentMonth.getValue() <= 9) {
	           // Q3: July - September
	           startOfQuarter = LocalDate.of(today.getYear(), Month.JULY, 1);
	           endOfQuarter = LocalDate.of(today.getYear(), Month.SEPTEMBER, Month.SEPTEMBER.length(today.isLeapYear()));
	       } else {
	           // Q4: October - December
	           startOfQuarter = LocalDate.of(today.getYear(), Month.OCTOBER, 1);
	           endOfQuarter = LocalDate.of(today.getYear(), Month.DECEMBER, Month.DECEMBER.length(today.isLeapYear()));
	       }

	       // Format the dates (optional)
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	       String startOfQuarterStr = startOfQuarter.format(formatter);
	       String endOfQuarterStr = endOfQuarter.format(formatter);

	       // Print the start and end dates of the current quarter
	       System.out.println("Start of the quarter: " + startOfQuarterStr);
	       System.out.println("End of the quarter: " + endOfQuarterStr);
	}


	
}  
	
	


