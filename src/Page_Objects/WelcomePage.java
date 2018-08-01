package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	
	//POM
	
	WebDriver driver;
	
	By UserName_msg =By.xpath("//div[@class='ZrQ9j']");
	
	By Gmail_option = By.xpath("//a[@id='gb23']");
	
	By app = By.xpath("//a[@class='gb_b']");
	
	
	
	public WelcomePage(WebDriver driver) {
		
		this.driver = driver;
		
		}
	
	public String WelcomeMessage() {
		
		return driver.findElement(UserName_msg).getText();
				
	}
	
	public void clickGmail() {
		driver.findElement(Gmail_option).click();
	}
	
	public void clickapp() {
		
		driver.findElement(app).click();
	}
	
	

}
