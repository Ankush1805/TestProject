package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainTicketsPage {
	
	private WebDriver driver;
	
	
	@FindBy (xpath = "(//div[@class='pure-radiobutton booking_pnr-radio'])[2]")
	private WebElement checkPNRStatus;
	
	@FindBy (xpath = "//input[@id='text-box']")
	private WebElement PNR;
	
	@FindBy (xpath = "//button[text()='Check PNR Status']")
	private WebElement checkPNRStatusButton;
	
	//button[text()='Check PNR Status']
	
	public TrainTicketsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	
	public void clickOnCheckPNRStatus()
	{
		checkPNRStatus.click();
	}
	
	public void sendPNR(String pnr)
	{
		PNR.sendKeys(pnr);
	}
	
	public void clickOnCheckPNRStatusButton()
	{
		checkPNRStatusButton.click();
	}
	
	
	

}
