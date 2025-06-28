package org.sample;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.IfClosure;
import org.openqa.selenium.By;

public class forLoop extends BaseClass{

	public static void main(String[] args) {
		
		int weeks = 3;
	    int days = 7;

	    // outer loop prints weeks
	    for (int i = 1; i <= weeks; ++i) {
	      System.out.println("Week: " + i);

	      // inner loop prints days
	      for (int j = 1; j <= days; ++j) {
	        System.out.println("  Day: " + j);
	      }
	    }
	  }
	 private void laun() throws Throwable {
		
     edgeBrowser();
     maximizePage();
		launchUrl("https://subscriptions.test.acuitysoft.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		waitsVisibility(driver.findElement(By.xpath("//*[@id='email']")), 20);
		// waitsVisibility(sl.getEmailAddress(), 20);
		sendData(driver.findElement(By.cssSelector("input[type='email']")), "breippauffobraya-9100@yopmail.com");
		sendData(driver.findElement(By.cssSelector("input[type='email']")), "Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='email']")).click();
		doubleEnter();
		
		waitsVisibility(driver.findElement(By.xpath("(//*[@placeholder='Search...'])[2]")), 20);
		Thread.sleep(1000);
		sendData(driver.findElement(By.xpath("(//*[@placeholder='Search...'])[2]")), "Andica Limited");
		Thread.sleep(1000);
		try {
			waitsVisibility(driver.findElement(By.xpath("(//ngb-highlight[text()='Open'])[1]")), 20);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//ngb-highlight[text()='Open'])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//ngb-highlight[text()='Open'])[1]")).click();
		}
		
	}
	
	 
	
}
	
	
		  
		 
	
