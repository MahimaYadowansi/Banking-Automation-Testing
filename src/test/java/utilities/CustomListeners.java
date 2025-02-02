package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;

public class CustomListeners implements ITestListener {
	 private WebDriver driver;
	// Initialize Logger
	    private static final Logger logger = (Logger) LogManager.getLogger(CustomListeners.class);
	    @Override
	    public void onTestStart(ITestResult result) {
	    	
	    	logger.info("Test start: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        logger.info("Test passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	 logger.info("Test failed: " + result.getName());
	         
	         // Take screenshot on test failure
	         Object testInstance = result.getInstance();
	         if (testInstance instanceof TestBase) {  
	             this.driver = ((TestBase) testInstance).getDriver();
	             takeScreenshot(result.getName());
	         }
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	 logger.info("Test skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // This method can be used if you care about tests failing within a success percentage
	    }

	    @Override
	    public void onStart(ITestContext context) {
	    	 logger.info("Test suite started: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	 logger.info("Test suite finished: " + context.getName());
	    }
	    
	 // Method to take screenshot
	    private void takeScreenshot(String testName) {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

	        try {
	            FileUtils.copyFile(srcFile, new File(screenshotPath));
	            logger.info("Screenshot saved: " + screenshotPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

	    
}

