package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	private WebDriver driver;

	@FindBy (xpath="//span[@class='title']")
	private WebElement completetext;
	
	@FindBy (xpath="complete-header")
	private WebElement confirmationMessage;
	
	@FindBy (xpath="//button[@id='back-to-products']")
	private WebElement backtohomeButton;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkcompletestatus() {
		return completetext.getText().contains("Complete!");
	}
	
	public boolean getconfirmationMessage() {
		return confirmationMessage.getText().contains("Thank you for your order!");
	}
	
	public ProductPage gotohomeButton() {
		backtohomeButton.click();
		return new ProductPage(driver);
	}
}
