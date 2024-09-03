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

public class CheckOutOverviewPageTest extends baseclass{
 
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	CheckOutOverviewPage checkOutOverviewPage;
	ConfirmationPage confirmationPage;
  
	
	@Test (groups="Sanity")
	public void verifypaymentinfo() throws InterruptedException {
		Log.startTestCase("verifypaymentinfo");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		cartPage = productPage.gotocart();
		checkOutPage=cartPage.clickcheckout();
		checkOutOverviewPage=checkOutPage.entershippingInformation();
		boolean result=checkOutOverviewPage.validatePaymentInfo();
		Assert.assertTrue(result);
		Log.endTestCase("verifypaymentinfo");
	}
	@Test (groups="Smoke")
	public void verifyshippinginfo() throws InterruptedException {
		Log.startTestCase("verifyshippinginfo");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		cartPage = productPage.gotocart();
		checkOutPage=cartPage.clickcheckout();
		checkOutOverviewPage=checkOutPage.entershippingInformation();
		boolean reasult=checkOutOverviewPage.validateshippinginfo();
		Assert.assertTrue(reasult);
		Log.endTestCase("verifyshippinginfo");
	}
	@Test (groups="Regression")
	public void clickfinishbutton() throws InterruptedException {
		Log.startTestCase("clickfinishbutton");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		cartPage = productPage.gotocart();
		checkOutPage=cartPage.clickcheckout();
		checkOutOverviewPage=checkOutPage.entershippingInformation();
		confirmationPage=checkOutOverviewPage.finish();
		String Actualurl=driver.getCurrentUrl();
		String Expectedurl="https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(Actualurl, Expectedurl);
		Log.endTestCase("clickfinishbutton");
		
	}
}
