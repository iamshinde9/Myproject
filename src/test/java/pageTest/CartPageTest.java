package pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonpage.baseclass;
import pageclasses.CartPage;
import pageclasses.CheckOutPage;
import pageclasses.LoginPage;
import pageclasses.ProductPage;
import utility.Log;

public class CartPageTest extends baseclass {

	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CheckOutPage checkOutPage;

	

	@Test (groups="Sanity")
	public void verifyremovebutton() throws InterruptedException {
		Log.startTestCase("verifyremovebutton");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		Log.info("Login Successfull");
		cartPage = productPage.gotocart();
		boolean reasult = cartPage.validateremovButton();
		Assert.assertTrue(reasult);
		Log.info("verified remove button on cart");
		Log.endTestCase("verifyremovebutton");
	}
	@Test(groups="Smoke")
	public void verifycontinueshoppingbutton() throws InterruptedException {
		Log.info("verifycontinueshoppingbutton");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		Log.info("Login Successfull");
		cartPage = productPage.gotocart();
		boolean result=cartPage.validatecontinueshopingbut();
		Assert.assertTrue(result);
		Log.info("verified Continue Button on cart");
		Log.info("verifycontinueshoppingbutton");
	}
	@Test (groups="Regression")
	public void proceedtocheckout() throws InterruptedException {
		Log.startTestCase("proceedtocheckout");
		loginPage = new LoginPage(driver);
		productPage = loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		loginPage = new LoginPage(driver);
		cartPage = productPage.gotocart();
		checkOutPage=cartPage.clickcheckout();
		Log.info("clicked checkout button");
		String Actualurl=driver.getCurrentUrl();
		String Expectedurl="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(Actualurl, Expectedurl);	
		Log.info("Matched URL");
		Log.endTestCase("proceedtocheckout");
	}

}
