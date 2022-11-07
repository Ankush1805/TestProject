package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetroPage {
	
	private WebDriver driver;
	private Actions act ;
	
	@FindBy (xpath = "//input[@type='text']")
	private WebElement metro;
	
	
	public MetroPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		act = new Actions(driver);
	}

	
	
	public void selectMetro()
	{
		metro.sendKeys("Mumbai");
		metro.sendKeys(Keys.ARROW_DOWN);
		metro.sendKeys(Keys.ENTER);
	}
	
	
	
}
