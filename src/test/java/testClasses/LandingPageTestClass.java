package testClasses;

import pomClasses.LandingPage;
import testClassUtilities.FetchData;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LandingPageTestClass extends BaseClass{
	
	LandingPage lp ;
	SoftAssert sa;

	@BeforeClass
	public void initializingLandingPageObject() {
		lp = new LandingPage(driver);	
		sa = new SoftAssert();
		System.out.println("initializing LandingPage Object......");
	}
	
	@Test(priority=1)
	public void verifyHealthInsuranceIconIsDisplayed() {
		logger=report.createTest("Verify If Health Insurance Icon Is Displayed");
		boolean actualResult=lp.checkHealthInsuranceIconIsDisplayed(); 
		sa.assertTrue(actualResult);
		System.out.println("Health Insurance Icon Displayed = " + actualResult);
		sa.assertAll();
	}
	
	@Test(priority=2)
	public void verifyHealthInsuranceIconText() throws EncryptedDocumentException, IOException {
		logger=report.createTest("verify Health Insurance Icon Text");
		String actualResult=lp.checkHealthInsuranceIconText();
		String expectedResult=FetchData.fromExcelSheet(1, 0);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult+" :: "+ expectedResult);
		sa.assertAll();
	}
	
	@Test(priority=3)
	public void verifyHealthInsuranceIconIsClickable() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Verify Health Insurance Icon Is Clickable");
		String actualResult=lp.clickHealthInsuranceIcon(); 
		String expectedResult = FetchData.fromExcelSheet(2, 1);
		Thread.sleep(3000);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult+" :: "+ expectedResult);
		sa.assertAll();
	}
	
	@Test(priority=4)
	public void moveToQuotePage1URL() throws EncryptedDocumentException, IOException {
		driver.navigate().back();
		logger=report.createTest("Move To QuotePage1 URL");
		driver.navigate().to(FetchData.fromExcelSheet(2, 1));
		String actualResult = driver.getCurrentUrl();
		String expectedResult =FetchData.fromExcelSheet(2, 1);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println();
		sa.assertAll();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
