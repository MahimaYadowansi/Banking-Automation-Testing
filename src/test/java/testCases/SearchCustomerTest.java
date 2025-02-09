package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import jdk.jfr.internal.Logger;
import utilities.ExtentManager;

public class SearchCustomerTest extends TestBase{
	@Test
	public void serachCustomer()
	{
	driver.findElement(By.xpath(or.getProperty("showCustomerBtn"))).click();
	ExtentManager.getTest().log(Status.INFO, "Clicked on show customer button");
	WebElement seachcustomer=driver.findElement(By.xpath(or.getProperty("searchCustomer")));
	seachcustomer.sendKeys("Hermoine");
	ExtentManager.getTest().log(Status.INFO, "Entered customer name");
	//WebElement customerTable=driver.findElement(By.xpath(or.getProperty("customerTable")));
	//WebElement customerRow=driver.findElement(By.xpath(or.getProperty("customerRow")));
	List<WebElement> accountNumbers = driver.findElements(By.xpath(or.getProperty("customerAccountNumber")));
	// Print the extracted account numbers
	for (WebElement acc : accountNumbers) {
		
	    System.out.println("Account Number: " + acc.getText());
	    ExtentManager.getTest().log(Status.INFO, "The account number of customer found");
	    logger.info("Customer account number found!");
	}
	
	
	}

}
