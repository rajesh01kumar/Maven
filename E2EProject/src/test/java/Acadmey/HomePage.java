package Acadmey;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialized() throws IOException {
		driver = InitilizeDriver();
		log.info("Driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String Password, String text)
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
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		// 0st set
		data[0][0] = "xxxxxxxxx";
		data[0][1] = "xxxxxxxxx";
		data[0][2] = "Login failed";

		// 1th set
		data[1][0] = "xxxxxxxxxx";
		data[1][1] = "xxxxxxxxx";
		data[1][2] = "Login Successful";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Browser is closed");

	}

}
