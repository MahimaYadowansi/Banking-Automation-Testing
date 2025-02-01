package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class BankManagerLoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		logger.info("Inside BankManagerLogin");
		driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		Thread.sleep(5);
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("AddCustomerBtn"))),"Login not Successfull");
		logger.info("Login Successfull");
		
	}

}
