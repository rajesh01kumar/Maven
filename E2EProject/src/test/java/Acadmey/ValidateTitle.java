package Acadmey;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginHomePage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialized() throws IOException {
		driver = InitilizeDriver();
		log.info("Driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void validateAfterloginPage(String userName, String Password, String text)
			throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		driver.manage().window().maximize();
		log.info("Maximized window size");

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		log.info("Email send on the editBox successfully");
		lp.getPassword().sendKeys(Password);
		log.info("Paasword send on the editBox successfully");
		lp.getLogin().click();
		log.info("Successfully Clicked on login page ");
		Thread.sleep(2000);
		log.info("After clicked waite for 2 secs ");
		// System.out.println(text);
		log.info(text);
		LoginHomePage lhp = new LoginHomePage(driver);

		Assert.assertEquals((lhp.getTitle()).getText(), "Rajesh123");
		log.info("Successfully validated text massage");
		Assert.assertTrue(lhp.getTitle().isDisplayed());
		log.info("Text are displayed on login page");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];

		// 0st set
		data[0][0] = "7897988634";
		data[0][1] = "rajesh@12345";
		data[0][2] = "Login Successfully";
		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser is closed");

	}
}
