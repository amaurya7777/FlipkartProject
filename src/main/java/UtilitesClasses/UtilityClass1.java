package UtilitesClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass1 {
	
	public static void moveTElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void moveByOffset(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(50,0).perform();
	}

	public static void expliciteWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void impilicitywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static List<String> getmultipledatafromexcel(int firstRow, int lastRow) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\amaur\\OneDrive\\Desktop\\mobile.xlsx");
		
		List<String> dataList = new ArrayList<String>();
		
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
		
		for(int i=firstRow; i<=lastRow; i++)
		{
			try {
				String stringData = sheet.getRow(i).getCell(1).getStringCellValue();
				dataList.add(stringData);
			}catch (Exception e)
			{
				long intData =  (long) sheet.getRow(i).getCell(1).getNumericCellValue();
				String string = String.valueOf(intData);
				dataList.add(string); 
			}
			
		}
		
		return dataList;
		
	}
	public static void scrollPage(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,100)");
	}
	
	public String screencapture(WebDriver driver) throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "screenshot.jpeg";
		File dest = new File("screenshot.jpeg");
		FileHandler.copy(file, dest);
		return path;
	}
	
	public String getConfigData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("configuration/config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
}
