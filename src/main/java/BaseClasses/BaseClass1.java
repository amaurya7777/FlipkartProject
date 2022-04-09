package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	
	@Parameters("browser")
	public static WebDriver getdriver(String a){
	
		if(a.equals("chrome"))
		{
//			WebDriverManager.chromedriver();
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\amaur\\eclipse-workspace\\FlipkartProject\\src\\main\\resources\\Browsers\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();

			return driver;
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "FlipkartProject/src/main/resources/Browsers/geckodriver.exe");
			
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();

			return driver;
		}
			
		
		
		
	}
}
