package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ElectricityBillPage;
import pages.HomePage;

public class VerifyPayElectricityBill {
	
public static void main(String[] args) {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		ElectricityBillPage electricityBillPage = new ElectricityBillPage(driver);
		
		
		
		homePage.clickOnPayElectricityBill();
		electricityBillPage.selectState();
		electricityBillPage.selectElectricityBoard();
		electricityBillPage.selectSubDivision();
		electricityBillPage.enterConsumerNo();
		electricityBillPage.clickOnProceedButton();
	
		
		
		driver.close();
		
		
		}

}
