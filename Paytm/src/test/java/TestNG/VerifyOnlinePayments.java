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
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
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
		
		String data = Utility.getDataFromExcel("Paytm", 1, 2);
		mobileRechargePage.sendMobileNo(data);
		
		data = Utility.getDataFromExcel("Paytm", 1, 3);
		mobileRechargePage.sendAmount(data);
		mobileRechargePage.clickOnProceedToRecharge();
	}
	

	@Test (priority = 2)
	public void verifyElectricityBillPayment()
	{
		testID = 2;
		
		homePage.clickOnPayElectricityBill();
		electricityBillPage.selectState();
		electricityBillPage.selectElectricityBoard();
		electricityBillPage.selectSubDivision();
		electricityBillPage.enterConsumerNo();
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
