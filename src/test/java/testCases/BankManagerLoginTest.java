package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.ExtentManager;

public class BankManagerLoginTest extends TestBase {
	@Test(description="Bank Manager Login functionality")
	public void loginAsBankManager() throws InterruptedException
	{
		
		
		
		logger.info("Inside BankManagerLogin");
		driver.findElement(By.xpath(or.getProperty("BankManagerLoginBtn"))).click();
		Thread.sleep(5);
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("AddCustomerBtn"))),"Login not Successfull");
		logger.info("Login Successfull");
		//extent repot
		 ExtentManager.getTest().log(Status.PASS, "Bank Manager login Successful");
	
		//to add custom message to reportng
		Reporter.log("Login Successfull");	
		
	}

}
