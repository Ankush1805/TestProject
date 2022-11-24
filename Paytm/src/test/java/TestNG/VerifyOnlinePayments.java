package TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.ElectricityBillPage;
import pages.HomePage;
import pages.MobileRechargePage;
import setup.Base;
import utils.Utility;

public class VerifyOnlinePayments extends Base {
	
	WebDriver driver;
	HomePage homePage;
	MobileRechargePage mobileRechargePage;
	ElectricityBillPage electricityBillPage;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output\\ExtentReport\\Extent.Html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMbjects()
	{
		homePage = new HomePage(driver);
		mobileRechargePage = new MobileRechargePage(driver);
		electricityBillPage = new ElectricityBillPage(driver);	
	}
	
	@BeforeMethod
	public void logintoPaytmApplication()
	{
		driver.get("https://paytm.com");
		
	}
	
	
	
	@Test (priority = 1)
	public void verifyMobileRechargePayment() throws EncryptedDocumentException, IOException
	{
		testID = 1;
		
		homePage.clickOnRechargePreapaidMobile();
		
		String data = Utility.getDataFromExcel("MobileRecharge", 2, 1);
		mobileRechargePage.sendMobileNo(data);
		
		data = Utility.getDataFromExcel("Mobile Recharge", 2, 2);
		mobileRechargePage.sendAmount(data);
		mobileRechargePage.clickOnProceedToRecharge();
	}
	

	@Test (priority = 2)
	public void verifyElectricityBillPayment() throws EncryptedDocumentException, IOException
	{
		testID = 2;
		
		homePage.clickOnPayElectricityBill();
		
		String stateData = Utility.getDataFromExcel("ElectricityBill", 2, 1);
		electricityBillPage.selectState(stateData);
		
		
		String boardData = Utility.getDataFromExcel("ElectricityBill", 2, 2);
		electricityBillPage.selectElectricityBoard(boardData);
		
		String divisionData = Utility.getDataFromExcel("ElectricityBill", 2, 3);
		electricityBillPage.selectSubDivision(divisionData);
		
		String consNoData = Utility.getDataFromExcel("ElectricityBill", 2, 4);
		electricityBillPage.sendConsumerNo(consNoData);
		
		electricityBillPage.clickOnProceedButton();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreen(driver, testID);
		}
		
		System.out.println("Logout");
	}
	
	@AfterClass
	public void clearObjects()
	{
		homePage = null;
		mobileRechargePage = null;
		electricityBillPage = null;	
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
}
