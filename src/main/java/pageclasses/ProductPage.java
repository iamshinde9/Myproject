package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private  WebDriver driver;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;

	@FindBy(xpath = "(//img[@alt='Sauce Labs Backpack'])[1]")
	private WebElement firstProduct;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addtocart;

	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	private WebElement removeButton;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validatecartlogo() {
		return cartIcon.isDisplayed();
	}

	public void addtocartproduct() throws InterruptedException {

		
			addtocart.click();
			 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.visibilityOf(removeButton));
			if (removeButton.getText().contains("Remove")) {
				System.out.println("remove Button is available");
			} else {
				System.out.println("remove button is not available");
			}
			
		}
	

	public CartPage gotocart() throws InterruptedException {
		
			addtocart.click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.visibilityOf(removeButton));
			if (removeButton.getText().contains("Remove")) {
				System.out.println("remove Button is available");
			} else {
				System.out.println("remove button is not available");
			}
		
		Thread.sleep(3000);
		cartIcon.click();
		return new CartPage(driver);
		
	}
}
