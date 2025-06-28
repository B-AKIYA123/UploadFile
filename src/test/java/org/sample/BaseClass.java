package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static WebDriverWait w;
	public static Robot r;
	public static Select s;
	public static FileInputStream fi;
	public static XSSFWorkbook book;
	

	// Browser Launch
	public static void loadBrowser() {
	//	WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().browserVersion("123.0.6312.59").setup();
//		WebDriverManager.chromedriver().proxy("server:port").setup();
		driver = new ChromeDriver();
	}
	public static  void fireFox() {
	   
		WebDriverManager.firefoxdriver().driverVersion("124.0.1").setup();
		driver = new FirefoxDriver();
	}

	public static void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	// URL Launch
	public static void launchUrl(String url) {
		driver.get(url);
	}

	// MaxiMize
	public static void maximizePage() {
		driver.manage().window().maximize();

	}

	public static String currentUrl() {
		return driver.getCurrentUrl();
	}

	public static String pageTittle() {
		return driver.getTitle();
	}

	public static String retriveText(WebElement element2) {
		return element2.getText();
	}

	public static String retriveAttribute(WebElement element, String value) {
		return element.getAttribute(value);
	}

	public static void btnClick(WebElement element2) {
		element2.click();
	}

	public static void sendData(WebElement element, String txt) {
		element.sendKeys(txt);
	}

	public static void closePage() {
		driver.close();
	}

	public static void quitPage() {
		driver.quit();
	}

	// Actions
	public static void moveToActions(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public static void doubleClickActions(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public static void waitsVisibility(WebElement element, long timeoutsecond) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitsInVisibility(WebElement element, long timeoutsecond) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
		w.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitsClickable(WebElement element, long timeoutsecond) {
		w = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecond));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void refreshThePage() {
		driver.navigate().refresh();
	}
	public static void doubleEnter() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void enter() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
			}
	public static void tab() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);		
	}
	
	public static void selectandClear() throws Throwable   {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);		
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);		
	}

	
	// Take Screenshot
	public static void takeScreenShot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\Bakiya Rubini\\eclipse-workspace1\\AndicaAcctsoft\\ScreenShot\\" + name + ".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    //Select Class
	public static void selectByVal(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);		
	}

	public static void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	public static void triggerMouseover(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var event = new MouseEvent('mouseover', {bubbles: true});" +
                        "arguments[0].dispatchEvent(event);";
        js.executeScript(script, element);
    }
 
    // Function to capture tooltip message using JavaScript
    public static String getTooltipMessage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.querySelector('selector_of_tooltip_element').innerText;";
        return (String) js.executeScript(script);
    }
    
    public static void dateMethod(int month,int year) {
    	Date currentDate1 = new Date(); 
    	Calendar calendar1 = Calendar.getInstance(); 
    	calendar1.setTime(currentDate1); 
    	calendar1.add(Calendar.DAY_OF_MONTH, month); 
    	calendar1.add(Calendar.YEAR, year); 
    	Date previousDate1 = calendar1.getTime(); 
    	SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy"); 
    	String previousDateString1 = dateFormat1.format(previousDate1); 
    	

	}

	public static void selectByText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}	
	   public static String readDataFromExcel(String filename,String sheetname,int row,int cell) throws Throwable {
//			File f =new File("C:\\Users\\Bakiya Rubini\\eclipse-workspace1\\AndicaAcctSoft\\Files\\validation.xlsx");
		   File f =new File(System.getProperty("user.dir")+"/Files/"+filename+".xlsx");
//			fi = new FileInputStream(f);
//			book = new XSSFWorkbook(fi);
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {
			}			
			try {
				book = new XSSFWorkbook(fi);
			} catch (IOException e) {
			}
			Sheet sheet = book.getSheet(sheetname);
			Row row2 = sheet.getRow(row);
			Cell cell2 = row2.getCell(cell);
			String stringCellValue = cell2.getStringCellValue();
			return stringCellValue;	
			
			
			
//			int cellType = cell2.getStringCellValue();
//			String value = null;
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
			 
		}
	   public static String readDataFromExcelDecimalValue(String filename,String sheetname,int row,int cell) throws Throwable {
		   double cellValue = 0.0;
		//File f =new File("C:\\Users\\Bakiya Rubini\\eclipse-workspace1\\AndicaAcctSoft\\Files\\Calculations.xlsx");
		   File f =new File(System.getProperty("user.dir")+"/Files/"+filename+".xlsx");

		 Workbook workbook = new XSSFWorkbook(f);
		    Sheet sheet = workbook.getSheet(sheetname);
		    
		    Row row1= sheet.getRow(row);
		    Cell cell1 = row1.getCell(cell);
		    
		    if (cell1.getCellType() == CellType.NUMERIC) {
	            cellValue = cell1.getNumericCellValue();
	        }	    
		    	
		    DecimalFormat df = new DecimalFormat("#.00");
	        return df.format(cellValue);

}
	   public static String readDataFromExcelcom(String filename,String sheetname,int row,int cell) throws Throwable {
//			File f =new File("C:\\Users\\Bakiya Rubini\\eclipse-workspace1\\AndicaAcctSoft\\Files\\validation.xlsx");
		  
		   
		   File f =new File(System.getProperty("user.dir")+"/Files/"+filename+".xlsx");
//			fi = new FileInputStream(f);
//			book = new XSSFWorkbook(fi);
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {
			}			
			try {
				book = new XSSFWorkbook(fi);
			} catch (IOException e) {
			}
			Sheet sheet = book.getSheet(sheetname);
			Row row2 = sheet.getRow(row);
			Cell cell2 = row2.getCell(cell);
			String cellValue = "";
	        if (cell2 != null) {
	            switch (cell2.getCellType()) {
	                case STRING:
	                    cellValue = cell2.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell2)) {
	                    	 Date date = (Date) cell2.getDateCellValue();
	                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                        cellValue = dateFormat.format(date);
	                    } else {
	                        double numericValue = cell2.getNumericCellValue();
	                        // Format the numeric value to ensure it displays two decimal places
	                        DecimalFormat df = new DecimalFormat("0.00");
	                        cellValue = df.format(numericValue);
	                    }
	                    break;
	                case BOOLEAN:
	                    cellValue = String.valueOf(cell2.getBooleanCellValue());
	                    break;
	                case FORMULA:
	                    // Evaluate the formula and get the resulting cell value
	                    FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
	                    CellValue evaluatedValue = evaluator.evaluate(cell2);
	                    switch (evaluatedValue.getCellType()) {
	                        case STRING:
	                            cellValue = evaluatedValue.getStringValue();
	                            break;
	                        case NUMERIC:
	                            double numericValue = evaluatedValue.getNumberValue();
	                            DecimalFormat df = new DecimalFormat("0.00");
	                            cellValue = df.format(numericValue);
	                            break;
	                        case BOOLEAN:
	                            cellValue = String.valueOf(evaluatedValue.getBooleanValue());
	                            break;
	                        default:
	                            cellValue = "Unsupported cell type";
	                            break;
	                    }
	                    break;
	                case BLANK:
	                    cellValue = "";
	                    break;
	                default:
	                    cellValue = "Unsupported cell type";
	                    break;
	            }
	        }
	        
	       	        return cellValue;
	    }
	   public static String readDataFromExcelcom2(String sheetname,int row,int cell) throws Throwable {
			File f =new File("C:\\Users\\Bakiya Rubini\\Desktop\\Excel File for Testing Purpose\\Credentials.xlsx");
		  
		   
	//	   File f =new File(System.getProperty("user.home")+"/location2/"+"/location1/"+"/Files/"+filename+".xlsx");
//			fi = new FileInputStream(f);
//			book = new XSSFWorkbook(fi);
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {
			}			
			try {
				book = new XSSFWorkbook(fi);
			} catch (IOException e) {
			}
			Sheet sheet = book.getSheet(sheetname);
			Row row2 = sheet.getRow(row);
			Cell cell2 = row2.getCell(cell);
			String cellValue = "";
	        if (cell2 != null) {
	            switch (cell2.getCellType()) {
	                case STRING:
	                    cellValue = cell2.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell2)) {
	                    	 Date date = (Date) cell2.getDateCellValue();
	                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                        cellValue = dateFormat.format(date);
	                    } else {
	                    	double numericValue = cell2.getNumericCellValue();
	                        // Use a conditional format to preserve the original representation
	                        DecimalFormat df = new DecimalFormat("0.##");
	                        cellValue = df.format(numericValue);
	                    }
	                    break;
	                case BOOLEAN:
	                    cellValue = String.valueOf(cell2.getBooleanCellValue());
	                    break;
	                case FORMULA:
	                    // Evaluate the formula and get the resulting cell value
	                    FormulaEvaluator evaluator = book.getCreationHelper().createFormulaEvaluator();
	                    CellValue evaluatedValue = evaluator.evaluate(cell2);
	                    switch (evaluatedValue.getCellType()) {
	                        case STRING:
	                            cellValue = evaluatedValue.getStringValue();
	                            break;
	                        case NUMERIC:
	                            double numericValue = evaluatedValue.getNumberValue();
	                            if (DateUtil.isCellDateFormatted(cell2)) {
	                                Date date = DateUtil.getJavaDate(numericValue);
	                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                                cellValue = dateFormat.format(date);
	                            } else {
	                                DecimalFormat df = new DecimalFormat("0.##");
	                                cellValue = df.format(numericValue);
	                            }
	                            
	                            break;
	                        case BOOLEAN:
	                            cellValue = String.valueOf(evaluatedValue.getBooleanValue());
	                            break;
	                        default:
	                            cellValue = "Unsupported cell type";
	                            break;
	                    }
	                    break;
	                case BLANK:
	                    cellValue = "";
	                    break;
	                default:
	                    cellValue = "Unsupported cell type";
	                    break;
	            }
	        }
	        
	       
	        return cellValue;
	    }
	   
	   
	}


