package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import jdk.internal.org.jline.utils.Log;

public class LoginTest extends TestBase {
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		logger.info("Inside BankManagerLogin");
		driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		Thread.sleep(5);
		
		logger.info("Login Successfull");
		
	}

}
