package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.TrainTicketsPage;
import utils.Utility;

public class VerifyPNRStatus {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnPaytmForConsumer();
		homePage.clickOnTicketBooking();
		homePage.clickOnTrainTickets();
		
		TrainTicketsPage trainTicketsPage = new TrainTicketsPage(driver);
		
		trainTicketsPage.clickOnCheckPNRStatus();
		
		String excelData = Utility.getDataFromExcel("Paytm", 7, 0);
		trainTicketsPage.sendPNR(excelData);
		
		trainTicketsPage.clickOnCheckPNRStatusButton();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		}

}
