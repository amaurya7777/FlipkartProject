package TestClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseClass1;
import PomClasses.Address;
import PomClasses.HomePage;
import PomClasses.LoginPage;

public class Test1 {

	static WebDriver driver;
	LoginPage login;
	HomePage homepage;
	Address adresss;
	
	ExtentReports reports;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String a)
	{
		reports = new ExtentReports("ExtentReports.html", true);
		test = reports.startTest("Test1");
		
		driver = BaseClass1.getdriver(a);
	}
	@BeforeMethod
	public void beforeMethod()
	{
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		adresss = new Address(driver);	
	}
	
		@Test
	public void VerifyUserCanLogin() throws InterruptedException, IOException
	{		
		login.enterEmailid();
		Reporter.log("Entered emailID");
		login.enterPassword();
		Reporter.log("Enter password");
		login.clickSubmitButton();
		Reporter.log("Clicked Submit button");
	
		homepage.clickhover();
		String txt = homepage.getlogoutTxt();
		Assert.assertEquals(txt, "Logout");
		
		test.log(LogStatus.PASS, "Login Test Passed");
	}
	
	@DataProvider(name="dataSet")
	public String[][] dataToTest()
	{
		String[][] data = {{"Naruto","91523487962","412207","Wagholi"},{"Luffy","7865134896","412207","Wagholi"}};
		return data;
	}
	@Test(priority= 1,dataProvider="dataSet")
	public void z_VerifyUserCanAddAddress(String name,String mobNumber,String pincode,String locality) throws InterruptedException, EncryptedDocumentException, IOException
	{
		homepage.clickhover();
		homepage.profile();
		homepage.movePointer();
		adresss.clickOnManageAddress();
		
		Thread.sleep(2000);
		int firstCount = adresss.getcountAdress();
		
		adresss.clickOnAddAdress();
		
		List<String> dataList = new ArrayList<>();
		dataList.add(name);
		dataList.add(mobNumber);
		dataList.add(pincode);
		dataList.add(locality);
		adresss.getDataForAddress(dataList);
		
		adresss.enterAreaAddAdress1();
		adresss.scrolWebPage();
		Thread.sleep(2000);
		adresss.clickSaveAddress();
		Thread.sleep(2000);
		int newCount = adresss.getcountAdress();
		
		Assert.assertNotEquals(newCount, firstCount);
		
		test.log(LogStatus.PASS, "Add_Adrress Test Passed");
		}
	
	@Test
	public void test3()
	{
		System.out.println("test case 3");
		Reporter.log("Test 3 passed");
	}
	@Test
	public void test4()
	{
		System.out.println("test case 4");
		Reporter.log("Test 4 passed");
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE );
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(adresss.screencapture(driver)));
		}
	}
	
	@AfterClass
	public void afterclass()
	{
		reports.endTest(test);
		reports.flush();
		
//		driver.quit();
	}
}
