package org.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
        // Specify the user-data-dir and profile-directory to reuse an old session
		 		  
		 EdgeOptions options = new EdgeOptions();
//		 options.addArguments("--headless");
//		 options.addArguments("--disable-extensions");		
		 
         String userDataDir = "C:\\Users\\Bakiya Rubini\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default";
         options.addArguments("user-data-dir=" + userDataDir);
         options.addArguments("profile-directory=Edge Profile");    
         
         // Set the user data and profile directory in options       
	         driver = new EdgeDriver(options);        
             
            // Open a website to reuse the session data (e.g., cookies, sessions)
             driver.get("https://accounting.test.acuitysoft.com");
             
            System.out.println("Title: " + driver.getTitle());
    // Set the user data and profile directory in options
         driver.manage().window().maximize();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                
   
    // Initialize the EdgeDriver with these options         
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
         emailField.sendKeys("bakiya.rubini@acuitysoft.com");
              
         WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
         password.sendKeys("Pass@123");
         
    Thread.sleep(1000);   
    
      try {
    	  emailField.click();  
    	  Robot r = new Robot();
    		r.keyPress(KeyEvent.VK_ENTER);
    		r.keyRelease(KeyEvent.VK_ENTER);
    		r.keyPress(KeyEvent.VK_ENTER);
    		r.keyRelease(KeyEvent.VK_ENTER);
	} catch (Exception e) {	
		  Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
  		
	}
	
	
}
