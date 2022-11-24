package TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.BusTicketsPage;
import pages.HomePage;
import pages.TrainTicketsPage;
import setup.Base;
import utils.Utility;


public class VerifyOnlineTicketsBooking extends Base{
	
	WebDriver driver;
	HomePage homePage;
	BusTicketsPage busTicketsPage;
	TrainTicketsPage trainTicketsPage ;
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
	public void createPOMObjects()
	{
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void openTicketsBookingOption()
	{
		driver.get("https://paytm.com");
		homePage.clickOnPaytmForConsumer();
	}
	
	
	@Test (priority = 1)
	public void verifyBusTicketsBooking() throws EncryptedDocumentException, IOException
	{
		testID=11;
		
		homePage.clickOnTicketBooking();
		homePage.clickOnBusTickets();
		busTicketsPage = new BusTicketsPage(driver);
		busTicketsPage.clickOnRoundTrip();
		
		String excelData = Utility.getDataFromExcel("Paytm", 4, 0);
		busTicketsPage.sendFrom(excelData);
		
		excelData = Utility.getDataFromExcel("Paytm", 4, 1);
		busTicketsPage.sendTo(excelData);
		
		busTicketsPage.clickOnDepartureDate();
		busTicketsPage.selectDepartureDate();
		busTicketsPage.clickOnReturnDate();
		busTicketsPage.selectReturnDate();
		busTicketsPage.clickOnSearchButton();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		Assert.assertEquals(url, "https://paytm.com/bus-tickets");
		Assert.assertEquals(title, "Bus Tickets Booking Online, Book Volvo Bus Tickets - Paytm");

	}
	

	@Test (priority = 2)
	public void verifyPNRStatus() throws EncryptedDocumentException, IOException
	{
		testID=12;
		
		homePage.clickOnTicketBooking();
		homePage.clickOnTrainTickets();
		trainTicketsPage = new TrainTicketsPage(driver);
		trainTicketsPage.clickOnCheckPNRStatus();
		
		String excelData = Utility.getDataFromExcel("Paytm", 7, 0);
		trainTicketsPage.sendPNR(excelData);
		trainTicketsPage.clickOnCheckPNRStatusButton();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(url, "https://paytm.com/train-tickets/pnr-enquiry/2245851073/-");
		soft.assertEquals(title, "PNR enquiry");
		
		soft.assertAll();
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
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
	
}


