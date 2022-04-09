package PomClasses;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitesClasses.UtilityClass1;

public class Address extends UtilityClass1{

	WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement addAddress;
	
	
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement areaAddress;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAddress;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> countAddress;
	

	public Address(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnManageAddress() throws InterruptedException
	{
		manageAddress.click();
		Thread.sleep(2000);
	}
	
	public void clickOnAddAdress()
	{
		addAddress.click();
	}
	
	public void enterAreaAddAdress1()
	{
		areaAddress.sendKeys("Raisoni College");
	}
	
	public void clickSaveAddress()
	{
		saveAddress.click();
	}
	
	public void getDataForAddress(List<String> a)throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		for (int i=1 ; i<=4 ;i++)
		{
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			element.sendKeys(a.get(i-1));
		}
	}	
	
	public void scrolWebPage()
	{
		scrollPage(driver);
	}
	public int getcountAdress()
	{
		return countAddress.size();
	}
	public void screencapture()
	{
		screencapture();
	}
}
