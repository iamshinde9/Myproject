package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	private  WebDriver driver;
	
	
	@FindBy (xpath="//button[@id='remove-sauce-labs-backpack']")
	private WebElement removebutton;
	
	@FindBy (id="continue-shopping")
	private WebElement cotinueshopingbut;
	
	@FindBy (id="checkout")
	private WebElement checkoutbutton;
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateremovButton() {
		return removebutton.isDisplayed();
	}

	public boolean validatecontinueshopingbut() {
		return cotinueshopingbut.isDisplayed();
	}
	
	public CheckOutPage clickcheckout() {
		checkoutbutton.click();
		return new CheckOutPage(driver);
	}
}
