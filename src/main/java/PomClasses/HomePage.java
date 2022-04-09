package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitesClasses.UtilityClass1;

public class HomePage extends UtilityClass1{
	
	WebDriver driver;
	WebElement element;
	
	@FindBy(xpath="(//div[@class='exehdJ'])[1]")
	private WebElement hover;
	
	@FindBy(xpath="//div[text()='My Profile']")
	private WebElement profile;
	
	@FindBy(xpath="(//li[@class='_2NOVgj'])[10]")
	private WebElement logout;
	
	public	HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickhover() throws InterruptedException 
	{
		Thread.sleep(2000);
		moveTElement(driver, hover);
	}
	public void profile() throws InterruptedException
	{
		profile.click();
		Thread.sleep(2000);
	}
	public String getlogoutTxt()
	{
		return logout.getText();
	}
	public void waitToLoadPage()
	{
		expliciteWait(driver, logout);
	}
	
	public void movePointer()
	{
		moveByOffset(driver);
	}

}
