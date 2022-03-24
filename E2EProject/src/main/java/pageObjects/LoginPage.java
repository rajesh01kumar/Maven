package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	/* priavte locators */
	private By email = By.cssSelector("input[class='_2IX_2- VJZDxU']");
	private By password = By.cssSelector("input[type='password']");
	private By login = By.xpath("//button[@type='submit']//span[contains(text(),'Login')]");
	// By title=By.cssSelector("._2Xfa2_ div:nth-child(3)");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * public methods-So here we are achieving encapsulation concepts-means we are
	 * accessing private locators in our public methods by hiding implementation of
	 * private locators
	 */
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
