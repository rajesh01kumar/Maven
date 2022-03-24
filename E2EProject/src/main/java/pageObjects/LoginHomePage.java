package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHomePage {
	
	public WebDriver driver;
	
	By title=By.cssSelector("._2Xfa2_ div:nth-child(3)");
	
	public LoginHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	

}
