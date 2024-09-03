package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
	
	private WebDriver driver;

	@FindBy (xpath="//div[text()='SauceCard #31337']")
	private WebElement paymentinfo;
	
	@FindBy (xpath="//div[text()='Free Pony Express Delivery!']")
	private WebElement shippinginfo;
	
	@FindBy (id="finish")
	private WebElement FinishButton;
	
	public CheckOutOverviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePaymentInfo() {
		return paymentinfo.getText().endsWith("31337");
	}
	
	public boolean validateshippinginfo() {
		return shippinginfo.getText().contains("Free Pony Express Delivery");
	}
	
	public ConfirmationPage finish() {
		FinishButton.click();
		return new ConfirmationPage(driver);
	}
}