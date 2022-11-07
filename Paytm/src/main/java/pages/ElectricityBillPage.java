package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectricityBillPage {
	
	private WebDriver driver;
	
		
		@FindBy (xpath = "(//input[@type='text'])[1]")
		private WebElement state;
		
		@FindBy (xpath = "(//input[@type='text'])[2]")
		private WebElement electricityBoard;
		
		@FindBy (xpath = "(//input[@type='text'])[3]")
		private WebElement subDivision;
		
		@FindBy (xpath = "(//input[@type='text'])[4]")
		private WebElement consumerNo;
		
		@FindBy (xpath = "//button[text()='Proceed']")
		private WebElement proceedButton;
		
		
		
		public ElectricityBillPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver ;
		}
		
		// Pay Electricity Bill	
		
		
		
		public void selectState()
		{
			state.sendKeys("Maha");
			state.sendKeys(Keys.ARROW_DOWN);
			state.sendKeys(Keys.ENTER);
		}
		
		public void selectElectricityBoard()
		{
			electricityBoard.sendKeys("Maha");
			electricityBoard.sendKeys(Keys.ARROW_DOWN);
			electricityBoard.sendKeys(Keys.ENTER);
		}
		
		public void selectSubDivision()
		{
			subDivision.sendKeys("4327");
			subDivision.sendKeys(Keys.ARROW_DOWN);
			subDivision.sendKeys(Keys.ARROW_DOWN);
			subDivision.sendKeys(Keys.ARROW_DOWN);
			subDivision.sendKeys(Keys.ENTER);
		}
		
		public void enterConsumerNo()
		{
			consumerNo.sendKeys("450010304712");
		}
		
		public void clickOnProceedButton()
		{
			proceedButton.click();
		}



}
