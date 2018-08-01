package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Gmail_Log_In_Page {
	
	WebDriver driver;
	
	By Gmailuser = By.id("identifierId");
	By GmailPassword = By.xpath("//input[@name='password']");
	By Nxtbutton = By.xpath("//content[@class ='CwaK9']/Span[contains(text(),'Next')]");
	
	
	// This is for driver
	public Gmail_Log_In_Page(WebDriver driver) {
		this.driver = driver;
			
	}
	
	// this is for user name element
	public void username (String userid) {
		
		driver.findElement(Gmailuser).sendKeys(userid);
	}
	
	// this is for  next button
	public void clickNext() {
		
		driver.findElement(Nxtbutton).click();
	}
	
	
	// this is for passowrd
	public void password (String pass) {
		driver.findElement(GmailPassword).sendKeys(pass);
	}	

	
	
	
	public void Login (String userid, String pass ) {
		
		
		this.username(userid);
		
		this.clickNext();
		

		
		this.password(pass);
		
		this.clickNext();
		
	}
}
