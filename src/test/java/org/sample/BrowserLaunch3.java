package org.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch3 {

	public static WebDriver driver;
	
	 public static void edgeBrowserwithVersion() throws Throwable {
	        // Set up the Edge WebDriver with a specific version
		 WebDriverManager.edgedriver().setup();
	        // Specify the user-data-dir and profile-directory to reuse an old session
			 		  
			 EdgeOptions options = new EdgeOptions();
//			 options.addArguments("--headless");
//			 options.addArguments("--disable-extensions");		
			 
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
	      
	      
	        try {
	            Thread.sleep(15000); // Wait for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	 
	        // Save cookies to a file
	        saveCookies(driver, "cookies.dat");
	 
	        // Close the browser
	        driver.quit();
	    }
	
	 public static void loadCookies(WebDriver driver, String filePath) {
	        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\Bakiya Rubini\\Documents\\cookies.dat");
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            Set<Cookie> cookies = (Set<Cookie>) in.readObject();
	            for (Cookie cookie : cookies) {
	                driver.manage().addCookie(cookie);
	            }
	            System.out.println("Cookies have been loaded from " + filePath);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static void saveCookies(WebDriver driver, String filePath) {
	        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Bakiya Rubini\\Documents\\cookies.dat");
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
	            Set<Cookie> cookies = driver.manage().getCookies();
	            out.writeObject(cookies);
	            System.out.println("Cookies have been saved to " + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	   
				
		    public static void main(String[] args) throws Throwable {
		        edgeBrowserwithVersion();
		 
		        // To load cookies in a new session
		        WebDriverManager.edgedriver().driverVersion("131.0.2903.63").setup();
		        driver = new EdgeDriver();
		        driver.get("https://accounting.test.acuitysoft.com"); // Navigate to the same domain first
		        loadCookies(driver, "cookies.dat"); // Load cookies
		        driver.navigate().refresh(); // Refresh to apply cookies
		         
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
