package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BusTicketsPage;
import pages.HomePage;
import utils.Utility;

public class VerifyBusTicketBooking {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnPaytmForConsumer();
		homePage.clickOnTicketBooking();
		homePage.clickOnBusTickets();
		
		BusTicketsPage busTicketsPage = new BusTicketsPage(driver);
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
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

}
