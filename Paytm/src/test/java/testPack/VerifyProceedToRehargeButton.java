package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.MobileRechargePage;
import utils.Utility;

public class VerifyProceedToRehargeButton {
	
	static int testId;
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	testId=1;
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		MobileRechargePage mobileRechargePage = new MobileRechargePage(driver);
		
		homePage.clickOnRechargePreapaidMobile();
		
		String data = Utility.getDataFromExcel("Paytm", 1, 2);
		mobileRechargePage.sendMobileNo(data);
		
		data = Utility.getDataFromExcel("Paytm", 1, 3);
		mobileRechargePage.sendAmount(data);
		mobileRechargePage.clickOnProceedToRecharge();
		
		Utility.captureScreen(driver, testId);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	
	

}
