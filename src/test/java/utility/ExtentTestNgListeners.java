package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestNgListeners implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	
	public void ConfigureReport() {
		
		//to use extent report we have to use this configureReport
		
		htmlReporter=new ExtentSparkReporter("ExtentReprt.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machin", "HP-Laptop");
		reports.setSystemInfo("OS", "Windows-10");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Tester", "Akshay Shinde");
		
		//Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent_TestNg+Listeners");
		htmlReporter.config().setReportName("My First Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) {
		//class madhe 4 method aahe pn he on start ekdach honar bz of 1 class jar 2 class aste tar 2nda onStart run jhal asta
		
		ConfigureReport();								//confugureReport ha test case cha exacution cha adhi configure karava lagnar and as weknow onStart method test case exacution cha aadhi run hotte so aapan ithe configureReport la configure kela	
		System.out.println("On Start Method invoked..");
	}

	public void onFinish(ITestContext context) {
		System.out.println("on Finish Method invoked..");
		reports.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("  Start Method  "  +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(" Method Successfully Pass  "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Pass test case is :  "+result.getName() , ExtentColor.GREEN));
	
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" Fail Method	"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is :  "+result.getName() , ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(" Mehtod Skip "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skip test case is :  "+result.getName() , ExtentColor.YELLOW));
	
	}

	

}
