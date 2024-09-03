package pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonpage.baseclass;
import pageclasses.CartPage;
import pageclasses.LoginPage;
import pageclasses.ProductPage;
import utility.Log;

public class ProductPageTest extends baseclass {
	
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
 
	
	  
	  @Test (groups="Sanity")
	  public void varifyCartLogo() {
		  Log.startTestCase("verifyvartLogo");
		  loginPage=new LoginPage(driver);
		  Log.info("user is going to login");
		  productPage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		  Log.info("Login successfull");
		  boolean result=productPage.validatecartlogo();
		  Assert.assertTrue(result);
		  Log.info("Varified cart Logo");
		  Log.endTestCase("varigyCartLogo");
	  }
	  @Test (groups="Smoke")
	  public void verifyaddtocartProduct() throws InterruptedException {
		  Log.startTestCase("verifyaddtocartProduct");
		  loginPage=new LoginPage(driver);
		  productPage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		  productPage.addtocartproduct();
		  Log.endTestCase("verifyaddtocartProduct");
	  }
	  
	  @Test (groups="Regression")
	  public void gotocartWithFirstProduct() throws InterruptedException {
		  Log.startTestCase("gotocartWithFirstProduct");
		  loginPage=new LoginPage(driver);
		  productPage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		  Log.info("Login Successfull");
		  cartPage=productPage.gotocart();
		  Log.info("usr on cart Page");
		  Thread.sleep(3000);
		  String Actualurl=driver.getCurrentUrl();
		  String Expectedurl="https://www.saucedemo.com/cart.html";
		  Assert.assertEquals(Actualurl, Expectedurl);
		  Log.info("Cart Page Url Matched");
		  Log.endTestCase("gotocartWithFirstProduct");
	  }
}
