package org.sample;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date currentDate = new Date(); 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(currentDate); 
		calendar.add(Calendar.DAY_OF_MONTH, +1); 
		calendar.add(Calendar.YEAR, 0); 
		Date previousDate = calendar.getTime(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		String previousDateString = dateFormat.format(previousDate); 
		System.out.println(previousDateString);	
		
		//31/05/2024
		Date currentDate1 = new Date(); 
		Calendar calendar1 = Calendar.getInstance(); 
		calendar1.setTime(currentDate1); 
		calendar1.add(Calendar.DAY_OF_MONTH, -7); 
		calendar1.add(Calendar.YEAR, 0); 
		Date previousDate1 = calendar1.getTime(); 
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy"); 
		String previousDateString1 = dateFormat1.format(previousDate1); 
		System.out.println(previousDateString1);	
//		int a=100;
//		int b = 10;
//		int c = a-b;
//		System.out.println(c);
		
		
		LocalDate currentDate11 = LocalDate.now();

        // Get the YearMonth object for the current month
        YearMonth yearMonth = YearMonth.from(currentDate11);

        // Get the last day of the month
        LocalDate endOfMonth = yearMonth.atEndOfMonth();

        // Optionally, format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = endOfMonth.format(formatter);

        // Print the end of the month date
        System.out.println("End of the month date: " + formattedDate);
        
                
        
        LocalDate currentDate2 = LocalDate.now();

        // Get the YearMonth object for the current month
        YearMonth yearMonth1 = YearMonth.from(currentDate2);

        // Get the last day of the month
        LocalDate endOfMonth1 = yearMonth1.atEndOfMonth().plusMonths(1);

        // Optionally, format the date
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate1 = endOfMonth1.format(formatter1);

        // Print the end of the Next month date
        System.out.println("End of the month date: " + formattedDate1);
        
        
        
        LocalDate currentDate3 = LocalDate.now();

        // Get the YearMonth object for the current month
        YearMonth yearMonth2 = YearMonth.from(currentDate2);

        // Get the last day of the month
        LocalDate endOfMonth2 = yearMonth1.atEndOfMonth().plusMonths(1);

        // Optionally, format the date
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate2 = endOfMonth1.format(formatter2);

        // Print the end of the Next month date
        System.out.println("End of the month date: " + formattedDate2);
        
        
    //    first and last date of a month
        LocalDate currentDate4 = LocalDate.now();
        
        // Get the first day of the current month
        LocalDate firstDayOfMonth = currentDate4.withDayOfMonth(1);
        System.out.println(firstDayOfMonth);
        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate4.withDayOfMonth(currentDate4.lengthOfMonth());
      
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate3 = firstDayOfMonth.format(formatter3);        
        String formattedDate4 = lastDayOfMonth.format(formatter3);
        
        System.out.println(formattedDate3);
        System.out.println(formattedDate4);
        
        // Format the dates as strings (optional)
//        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String startDate = firstDayOfMonth.format(formatter3);
//        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String endDate = lastDayOfMonth.format(formatter4);
//        System.out.println(formatter3);
//        System.out.println(formatter4);
        
        // Get the week start day of the current week
        
       LocalDate currentDate5 = LocalDate.now();
        
        // Get the start date of the current week (assuming Monday as the start of the week)
        LocalDate startOfWeek = currentDate5.with(DayOfWeek.MONDAY);
        
        // Get the end date of the current week (assuming Sunday as the end of the week)
        LocalDate endOfWeek = startOfWeek.plusDays(6);  // Adding 6 days to get to Sunday
        
        // Format the dates as strings (optional)
        DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String startDate = startOfWeek.format(formatter7);
        String endDate = endOfWeek.format(formatter7);
        System.out.println(startDate);
        System.out.println(endDate);
        // Print 
        
        
        LocalDate currentDate7 = LocalDate.now();

        // Determine the quarter
        int quarter = (currentDate7.getMonthValue() - 1) / 3 + 1; // Calculate quarter based on month

        // Calculate start and end dates of the quarter
        LocalDate startDate2, endDate2;
        switch (quarter) {
            case 1: // First quarter (January 1 - March 31)
            	startDate2 = LocalDate.of(currentDate7.getYear(), Month.JANUARY, 1);
            	endDate2 = LocalDate.of(currentDate7.getYear()+1900, Month.MARCH, 31);
                break;
            case 2: // Second quarter (April 1 - June 30)
            	startDate2 = LocalDate.of(currentDate7.getYear(), Month.APRIL, 1);
            	endDate2 = LocalDate.of(currentDate7.getYear(), Month.JUNE, 30);
                break;
            case 3: // Third quarter (July 1 - September 30)
            	startDate2 = LocalDate.of(currentDate7.getYear(), Month.JULY, 1);
            	endDate2 = LocalDate.of(currentDate7.getYear(), Month.SEPTEMBER, 30);
                break;
            case 4: // Fourth quarter (October 1 - December 31)
            	startDate2 = LocalDate.of(currentDate7.getYear(), Month.OCTOBER, 1);
            	endDate2 = LocalDate.of(currentDate7.getYear(), Month.DECEMBER, 31);
                break;
            default:
                throw new IllegalArgumentException("Invalid quarter: " + quarter);
        }

        // Format the dates as strings (optional)
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String startQuarterDate = startDate2.format(formatter5);
        String endQuarterDate = endDate2.format(formatter5);

        // Example usage: Output the dates or use them in Selenium operations
        System.out.println("Start Date of Quarter: " + startQuarterDate);
        System.out.println("End Date of Quarter: " + endQuarterDate);
       

		Date currentDateold = new Date();
		Calendar calendarold = Calendar.getInstance();
		calendarold.setTime(currentDateold);
		calendarold.add(Calendar.DAY_OF_MONTH, -325);
		calendarold.add(Calendar.YEAR, -6);
		Date previousDateold = calendarold.getTime();
		SimpleDateFormat dateFormatold = new SimpleDateFormat("dd/MM/yyyy");
		String previousDateStringold = dateFormatold.format(previousDateold);
		System.out.println(previousDateStringold);
		
		
		 
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");		       
        Date now = new Date();		       
        String formattedTime = sdf.format(now);			        
        System.out.println("Current time: " + formattedTime);
       
	}
	
	
	
	
	
	
}

