package pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonpage.baseclass;
import pageclasses.CartPage;
import pageclasses.CheckOutOverviewPage;
import pageclasses.CheckOutPage;
import pageclasses.ConfirmationPage;
import pageclasses.LoginPage;
import pageclasses.ProductPage;
import utility.Log;

public class ConfirmationPageTest extends baseclass {
	
	
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	CheckOutOverviewPage checkOutOverviewPage;
	ConfirmationPage confirmationPage;
  
	
	@Test (groups="Regression")
	public void confirmPage() throws InterruptedException {
		Log.startTestCase("confirmPage");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		Thread.sleep(5000);
		cartPage = productPage.gotocart();
		Thread.sleep(4000);
		checkOutPage=cartPage.clickcheckout();
		Thread.sleep(4000);
		checkOutOverviewPage=checkOutPage.entershippingInformation();
		Thread.sleep(4000);
		confirmationPage=checkOutOverviewPage.finish();
		Thread.sleep(4000);
		confirmationPage.gotohomeButton();
		Thread.sleep(4000);
		String Actualurl=driver.getCurrentUrl();
		String Expectedurl="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(Actualurl, Expectedurl);
		Log.endTestCase("confirmPage");
		
	}
}
