package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='login_logo']")
	private WebElement swaglabLogo;

	@FindBy(id = "user-name")
	private WebElement user;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(id = "login-button")
	private WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateswaglablogo() {
		return swaglabLogo.isDisplayed();
	}

	public boolean validateLoginbutton() {
		return loginbutton.isDisplayed();
	}

	public String getLoginTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public ProductPage login(String userid, String password) {
		
		user.sendKeys(userid);
		pass.sendKeys(password);
		loginbutton.click();
		return new ProductPage(driver);
	}
}
