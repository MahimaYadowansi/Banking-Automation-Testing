package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utilities.DataProviderTest;
import utilities.ExtentManager;

public class AddCustomerTest extends TestBase{
	@Test(dataProvider="addCustomer", dataProviderClass=DataProviderTest.class , description="Verify Customer Adding functionality")
	
	public void addCustomer(String FirstName, String LastName, String PostCode ) throws InterruptedException
	{
		
		
		
		
		
		try {
			
			
			
			driver.findElement(By.xpath(or.getProperty("AddCustomerBtn"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.xpath(or.getProperty("FirstName"))).sendKeys(FirstName);
		driver.findElement(By.xpath(or.getProperty("LastName"))).sendKeys(LastName);
		driver.findElement(By.xpath(or.getProperty("PostCode"))).sendKeys(PostCode);
		
		
		try {
			driver.findElement(By.xpath(or.getProperty("AddCustomerBtnClick"))).click();
			}catch(Exception e)
			{
				ExtentManager.getTest().fail("Can't click Add to customer button, Customer not added");
				 Assert.fail("Test failed: Unable to click Add Customer button");
				
	            return;  // Skip further execution
			}
			
		
		// Validate alert presence
        Alert alert;
        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assert.assertTrue(alertText.contains("Customer added successfully"), "Alert text mismatch!");
            alert.accept();
            
            ExtentManager.getTest().log(Status.PASS, "Customer added successfully");
        } catch (NoAlertPresentException e) {
        	
        	
        	 ExtentManager.getTest().fail("No alert displayed, customer not added!");
        	 
            throw e;
        }

        logger.info("Data added from excel sheet1");
	}

    catch(Exception e) {
    	
    	 //  Call takeScreenshot() from TestBase
        String screenshotPath = takeScreenshot("AddCustomerFailure");
        
        //  Log Failure in Extent Report with Screenshot
        ExtentManager.getTest().fail("Test Failed: " + e.getMessage(),
            com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        // Fail the test immediately
        Assert.fail("Test execution failed: " + e.getMessage());
    }
    
	
	}
}
