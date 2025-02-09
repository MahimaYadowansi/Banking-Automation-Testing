package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.ExtentManager;

public class OpenAccountTest extends TestBase{
	@Test
	public void openAccount() {
		
		try {
		driver.findElement(By.xpath(or.getProperty("openAccountBtn"))).click();
		ExtentManager.getTest().info("Open Account button clicked");
		WebElement selectCustomer =driver.findElement(By.xpath(or.getProperty("openCustomerSelect")));
		selectCustomer.click();
		Select select=new Select(selectCustomer);
		select.selectByVisibleText("Neville Longbottom");
		ExtentManager.getTest().info(" Account selected");
		
		WebElement selectCurrency=driver.findElement(By.xpath(or.getProperty("openCurrency")));
		
		selectCurrency.click();
		Select select1=new Select(selectCurrency);
		select1.selectByVisibleText("Pound");
		ExtentManager.getTest().info("Currency selected");
		try {
		driver.findElement(By.xpath(or.getProperty("processBtn"))).click();
		ExtentManager.getTest().info("Process button clicked");
		
		}catch(Exception e)
		{
			ExtentManager.getTest().fail("Unable to click on process button");
			return;
		}
		
		//Alert
		Alert alert;
		try {
			alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
			String alertText=alert.getText();
			Assert.assertTrue(alertText.contains("Account created successfully"),"Alert text mismatch!");
			alert.accept();
			ExtentManager.getTest().log(Status.PASS, "Account created successfully");
			
			
		}catch(Exception e)
		{
			ExtentManager.getTest().fail("Alert is not present");
			return;
		}
		
		}catch(Exception e)
		{
			ExtentManager.getTest().fail("Test Failed: " + e.getMessage());
		}
		logger.info("Account created successfully");
	}

}
