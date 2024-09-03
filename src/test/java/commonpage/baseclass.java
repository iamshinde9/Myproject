package commonpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public static void readconfigure() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
	
		prop.load(fis);
		
		
	}
	
	
/*	public static void browser() throws IOException {
		
		readconfigure();
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Desktop\\chromedriver128\\chromedriver-win64\\chromedriver.exe");
	
	//	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shree\\Desktop\\geckodriver\\geckodriver.exe");
		 
	//	 driver=new FirefoxDriver();
		 
	//	 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("https://www.saucedemo.com/");
		
		driver.get(prop.getProperty("url"));
		
	}*/
	
	//ithe beforemethod use kela tya mule aapan loginPage madhla pahila before method comment kela extend mule pahila ithalacha beforemethod exacute honar
	
	 @Parameters("browser")
	 @BeforeMethod (groups= {"Sanity","Smoke","Regression"})		//it is ncessassry to declair while performing grouping (sanity suit /smoke any many more)
	  public static void browser(String browserName) throws IOException {
	        
	    	
	    	
	        readconfigure();
	        
	        if (browserName.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Desktop\\chromedriver128\\chromedriver-win64\\chromedriver.exe");
	            driver = new ChromeDriver();
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shree\\Desktop\\geckodriver\\geckodriver.exe");
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Browser type not supported");
	        }
	        
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(prop.getProperty("url"));
	    }
	 @AfterMethod (groups= {"Sanity","Smoke","Regression"})
		public void teardown() {
		 if (driver != null) {
	            driver.quit(); // 
	        }
		}
	}
 

