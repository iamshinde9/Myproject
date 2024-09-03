package pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonpage.baseclass;
import dataProviders.ExcelDataProvider;
import pageclasses.LoginPage;
import utility.Log;

public class LoginPageTest extends baseclass {

	LoginPage loginPage;

// bz aapan beforemethod common class madhe use keli so aaplyala pratek testclass madhe before method lihaychi garaj nahi
// ithe test class la pratek beforemethod la parameter dyava lagla asta karan commonclass madhe aapn parameter dila aahe  
	
	/*	@BeforeMethod
	public void launchapp() throws IOException {
		browser();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}*/

	@Test(groups="Sanity")
	public void verifyLog() {
		Log.startTestCase("VerifyLogo");
		loginPage = new LoginPage(driver);
		boolean reasult = loginPage.validateswaglablogo();
		Log.info("Validating Logo");
		Assert.assertTrue(reasult);
		Log.endTestCase("VerifyLogo");
	}

	@Test(groups="Sanity")
	public void verifyLoginButton() {
		Log.startTestCase("verifyLoginButton");
		loginPage = new LoginPage(driver);
		boolean reasult = loginPage.validateLoginbutton();
		Log.info("Validating LoginButton");
		Assert.assertTrue(reasult);
		Log.endTestCase("verifyLoginButton");
	}

	@Test(groups="Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		loginPage = new LoginPage(driver);
		String ActualTitle = loginPage.getLoginTitle();
		String ExpectedTitle = "Swa Labs";
		Log.info("Title Verifying");
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		Log.endTestCase("verifyingTitle");

	}

	@Test(groups="Sanity", dependsOnMethods="verifyTitle")
	public void LoginTest() throws InterruptedException {
		Log.startTestCase("LoginTest");
		loginPage = new LoginPage(driver);
		Log.info("User going to enter userid and password");
		loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
		Log.info("Login succefully done");
		String title = driver.getTitle();
		Log.info("Verify HomePage Title");
		System.out.println(title);
		Log.info("title Print");
		Thread.sleep(3000);
		Log.endTestCase("LoginTest");

	}
	
	@Test(dataProvider="logindata", dataProviderClass=ExcelDataProvider.class ,priority=5, groups={"Sanity","Smoke"})
	public void LoginTest1(String userid, String password) throws InterruptedException {
		Log.startTestCase("LoginTest");
		loginPage = new LoginPage(driver);
		Log.info("User going to enter userid and password");
		loginPage.login(userid, password);
		Log.info("Login succefully done");
		String title = driver.getTitle();
		Log.info("Printing HomePage Title");
		System.out.println(title);
		Log.info("title Print");
		Thread.sleep(3000);
		Log.endTestCase("LoginTest");

	}
}
