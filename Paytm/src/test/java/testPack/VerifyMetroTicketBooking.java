package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.MetroPage;
import pages.MobileRechargePage;

public class VerifyMetroTicketBooking {
	
public static void main(String[] args) {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\Selenium\\chromedriver_win32(2)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://paytm.com");
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnRechargePreapaidMobile();
		
		MobileRechargePage mobileRechargePage = new MobileRechargePage(driver);
		
		mobileRechargePage.clickOnMetro();
		
		MetroPage metroPage = new MetroPage(driver);
		
		metroPage.selectMetro();
		
		
		
		
		
		
		
		}

}
