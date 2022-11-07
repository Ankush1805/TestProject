package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	private Actions act ;
	
	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[1]")
	private WebElement rechargePrepaidMobile;
	
	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[3]")
	private WebElement payElectricityBill;
	
	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[4]")
	private WebElement rechargeDTHConnection;
	
	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[5]")
	private WebElement bookGasCylinder;
	
	@FindBy (xpath = "(//div[@class='_2EGQY cqA0P'])[7]")
	private WebElement allPaymentServices;
	
	@FindBy (xpath = "//span[text()='Education']")
	private WebElement education;
	
	@FindBy (xpath = "(//div[@class='_3y5vS'])[1]")
	private WebElement paytmForConsumer;
	
	@FindBy (xpath = "//a[text()='Ticket booking']")
	private WebElement ticketBooking;
	
	@FindBy (xpath = "//a[text()='Bus Tickets']")
	private WebElement busTickets;
	
	@FindBy (xpath = "(//a[text()='Train Tickets'])[1]")
	private WebElement trainTickets;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		act = new Actions(driver);
	}
	
	
	
	public void clickOnRechargePreapaidMobile()
	{
		rechargePrepaidMobile.click();
	}
	
	public void clickOnPayElectricityBill()
	{
		payElectricityBill.click();
	}
	
	public void clickOnPaytmForConsumer()
	{
		act.moveToElement(paytmForConsumer).perform();
	}

	public void clickOnTicketBooking()
	{
		act.moveToElement(ticketBooking).perform();
	}
	
	public void clickOnBusTickets()
	{
		act.moveToElement(busTickets).click().build().perform();
	}
	
	public void clickOnTrainTickets()
	{
		act.moveToElement(trainTickets).click().build().perform();
	}

}
