package testClasses;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import testClassUtilities.CaptureScreenshot;
import testClassUtilities.OpenDriver;
import testClassUtilities.Waits;

public class BaseClass {
	
	static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static ExtentHtmlReporter extent;
	
	
	@BeforeTest
	public void openBrowser() {
		WebDriver driver=OpenDriver.openBrowser("chrome","https://www.policybazaar.com");
	    this.driver=driver;
	    Waits.implicitWait(driver, 5);
	    
	    extent = new ExtentHtmlReporter("C:"+File.separator+"Users"+File.separator+"Rajat Dhawade"+File.separator+"eclipse-workspace"+File.separator+"Bazaar"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExtentReport"+System.currentTimeMillis()+".html");
        report = new ExtentReports();
        report.attachReporter(extent);
	}
	
	@AfterMethod
	public void capturesFailedScreenshots(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String path=CaptureScreenshot.takeSS(driver, "error");
			logger.fail("This Test Case is Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		report.flush();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	

}
