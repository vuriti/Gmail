package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page_Objects.Gmail_Log_In_Page;
import Page_Objects.WelcomePage;

public class Gmail {
	
	WebDriver driver ;
	
	Gmail_Log_In_Page login ;
	
	WelcomePage WP ;
	
	public void Invokbrowser(String browserType) {

		System.out.println(browserType + "Browser is opening to Run the Tests ");

		if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Selenium Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Selenium Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			System.err.println("invalid browser option");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		System.out.println("***** Befor Method is completed ******");

	}

	@BeforeTest
	
	public void openurl() {
		Invokbrowser("chrome");
		
		driver.get("https://accounts.google.com");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
	}
	
	
	
	
	
  @Test (priority = 100)
  public void logintest() throws Throwable {
	  
	  login = new  Gmail_Log_In_Page(driver);
	  
	  System.out.println(driver.getTitle());
	  
	  login.username("vuriti.teja128");
	  login.clickNext();	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  login.password("vuritikotaiah");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  login.clickNext();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  String Paget1 = driver.getTitle();
	  
	  String paget1_exp = "Sign in - Google Accounts";
	  
	  Assert.assertEquals(Paget1, paget1_exp);
	  
	  Thread.sleep(5000);
  }
  
  @Test (priority =200)
  public void welcome() throws Throwable {
	  
	  
	  
	  WP =new WelcomePage(driver);
	  
	  
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	   String Msg1 = WP.WelcomeMessage();
	   
	   System.out.println(Msg1);
	   
	   String msgexp ="Welcome, Satyam Chandhu";
	   
	   WP.clickapp();
	   
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   
	   WP.clickGmail();
	  
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Assert.assertEquals(Msg1, msgexp);
	   
	   System.out.println(driver.getTitle());
	   
	   
	  
  }
 
 
 //@AfterTest
 
 public void close() {
	 
	 driver.close();
	 
 }
  
}
