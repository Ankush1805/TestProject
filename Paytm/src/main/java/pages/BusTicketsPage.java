package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusTicketsPage {
	
	private WebDriver driver;
	private Actions act ;
	
	@FindBy (xpath = "//label[text()='Round Trip']")
	private WebElement roundTrip;
	
	@FindBy (xpath = "(//input[@id='text-box'])[1]")
	private WebElement from;
	
	@FindBy (xpath = "(//input[@id='text-box'])[2]")
	private WebElement to;
	
	@FindBy (xpath = "(//input[@class='fl-input _9KqY'])[1]")
	private WebElement departureDate;
	
	@FindBy (xpath = "//div[@aria-label='day-21']")
	private WebElement selectDepartureDate;
	
	
	@FindBy (xpath = "(//input[@class='fl-input _9KqY'])[2]")
	private WebElement returnDate;
	
	@FindBy (xpath = "//div[@aria-label='day-23']")
	private WebElement selectReturnDate;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement searchButton;
	
	public BusTicketsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		act = new Actions(driver);
	}
	
	public void clickOnRoundTrip()
	{
		roundTrip.click();
	}
	
	public void sendFrom(String fromLocation)
	{
		from.sendKeys(fromLocation);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
	}
	
	
	public void sendTo(String toLocation)
	{
		to.sendKeys(toLocation);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
	}
	
	public void clickOnDepartureDate()
	{
		departureDate.click();
	}
	
	public void selectDepartureDate()
	{
		selectDepartureDate.click();
	}

		
	public void clickOnReturnDate()
	{
		returnDate.click();
	}
	
	public void selectReturnDate()
	{
		selectReturnDate.click();
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}

}
