package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
	
	private WebDriver driver;
	private Actions act ;
	
	
		
		@FindBy (xpath = "//input[@type='tel']")
		private WebElement mobileNo;
		
		@FindBy (xpath = "//div[@class='_1exI']")
		private WebElement operator;
		
		@FindBy (xpath = "//span[text()='Jio']")
		private WebElement jio;
		
		@FindBy (xpath = "(//input[@type='text'])[3]")
		private WebElement amount;
		
		@FindBy (xpath = "//button[text()='Rs. 419']")
		private WebElement plan3GBPerDay;
		
		@FindBy (xpath = "//button[@class='_11kC  _15qf _2qE6']")
		private WebElement proceedToRecharge;
		
		@FindBy (xpath = "//a[@class='_2iSj']")
		private WebElement close;
		
		@FindBy (xpath = "//span[text()='Metro']")
		private WebElement metro;
		
		
		
		
		
		public MobileRechargePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver ;
			act = new Actions(driver);
		}
		
		
		
		
	
		
		public void sendMobileNo(String mobno)
		{
			mobileNo.sendKeys(mobno);
		}
		
		public void clickOnOperator()
		{
			operator.click();
		}
		
		public void selectJio()
		{
			jio.click();
		}
		
		public void sendAmount(String amt)
		{
			amount.sendKeys(amt);;
		}

		public void selectPlan()
		{
			plan3GBPerDay.click();
		}
		
		public void clickOnProceedToRecharge()
		{
			proceedToRecharge.click();
		}
		
		public void clickOnMetro()
		{
			metro.click();
		}


}
