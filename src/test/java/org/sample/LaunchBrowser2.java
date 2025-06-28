package org.sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser2 {

	
	public static WebDriver driver;
	 
    public static void edgeBrowserwithVersion() {
        // Set up the Edge WebDriver with a specific version
        WebDriverManager.edgedriver().driverVersion("131.0.2903.63").setup();
        driver = new EdgeDriver(); 
        
        driver.get("https://accounting.test.acuitysoft.com"); 
        // Wait for a while to ensure the cookies are set (you can implement a better wait)
        try {
            Thread.sleep(5000); // Wait for 5 seconds
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
	         
	        driver.manage().window().maximize();
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("bakiya.rubini@acuitysoft.com");
	        Thread.sleep(1000);
	        driver.findElement(By.id("password")).sendKeys("Pass@123");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='email']")).click();
	        
	       Actions a = new Actions(driver);
	       a.doubleClick().perform();
	 
	        // Close the browser
//	        driver.quit();
	    }
	}

