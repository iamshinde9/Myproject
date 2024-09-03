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
import pageclasses.LoginPage;
import pageclasses.ProductPage;
import utility.Log;

public class CheckOutPageTest extends baseclass {
	
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	CheckOutOverviewPage checkOutOverviewPage;
  
	
	@Test (groups="Regression")
	public void verifyInformation() throws InterruptedException {
		Log.startTestCase("verifyInformation");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		cartPage = productPage.gotocart();
		checkOutPage=cartPage.clickcheckout();
		checkOutOverviewPage=checkOutPage.entershippingInformation();
		String Actualurl=driver.getCurrentUrl();
		String Expectedurl="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(Actualurl, Expectedurl);
		Log.endTestCase("verifyInformation");
	}
}
