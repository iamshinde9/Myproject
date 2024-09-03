package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	private WebDriver driver;

	@FindBy (id="first-name")
	private WebElement userid;
	
	@FindBy (id="last-name")
	private WebElement passwords;
	
	@FindBy (id="postal-code")
	private WebElement zipcod;
	
	@FindBy (id="continue")
	private WebElement continuebutton;
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CheckOutOverviewPage entershippingInformation() {
		userid.sendKeys("Akshay");
		passwords.sendKeys("shinde");
		zipcod.sendKeys("1234");
		continuebutton.click();
		return new CheckOutOverviewPage(driver);
	}
}
