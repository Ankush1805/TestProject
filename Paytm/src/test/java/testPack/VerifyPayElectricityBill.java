package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ElectricityBillPage;
import pages.HomePage;
import utils.Utility;

public class VerifyPayElectricityBill {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		ElectricityBillPage electricityBillPage = new ElectricityBillPage(driver);
		
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
	
		
		
		driver.close();
		
		
		}

}
