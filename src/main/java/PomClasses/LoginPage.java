package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitesClasses.UtilityClass1;

public class LoginPage extends UtilityClass1{

	WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID ;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password ;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submit ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterEmailid() throws IOException
	{
//		emailID.sendKeys("7350402637");
		emailID.sendKeys(getConfigData("email"));
		
	}
	
	public void enterPassword() throws IOException
	{
//		password.sendKeys("Akash1996");
		password.sendKeys(getConfigData("password"));
	}
	
	public void clickSubmitButton() throws InterruptedException
	{
		submit.click();
		Thread.sleep(2000);
	}
}
