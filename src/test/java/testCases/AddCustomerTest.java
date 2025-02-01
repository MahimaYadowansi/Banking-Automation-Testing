package testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.DataProviderTest;

public class AddCustomerTest extends TestBase{
	@Test(dataProvider="addCustomer", dataProviderClass=DataProviderTest.class)
	
	public void addCustomer(String FirstName, String LastName, String PostCode ) throws InterruptedException
	{
		driver.findElement(By.xpath(or.getProperty("AddCustomerBtn"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.xpath(or.getProperty("FirstName"))).sendKeys(FirstName);
		driver.findElement(By.xpath(or.getProperty("LastName"))).sendKeys(LastName);
		driver.findElement(By.xpath(or.getProperty("PostCode"))).sendKeys(PostCode);
		
		driver.findElement(By.xpath(or.getProperty("AddCustomerBtnClick"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// Validate alert text (replace with expected text)
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Customer added successfully"));  
        
        Thread.sleep(5000);
        alert.accept();
		
		logger.info("Data added from excel sheet1");
		}
	

}
