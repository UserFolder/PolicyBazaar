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
	}
	
	@Test(priority=1)
	public void verifyHealthInsuranceIconIsDisplayed() {
		logger=report.createTest("Verify If Health Insurance Icon Is Displayed");
		boolean actualResult=lp.checkHealthInsuranceIconIsDisplayed();
		sa.assertTrue(actualResult);
		System.out.println(actualResult);
	}
	
	@Test(priority=2)
	public void verifyHealthInsuranceIconText() throws EncryptedDocumentException, IOException {
		logger=report.createTest("verify Health Insurance Icon Text");
		String actualResult=lp.checkHealthInsuranceIconText();
		String expectedResult=FetchData.fromExcelSheet(1, 0);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult+" :: "+ expectedResult);
		
	}
	
	@Test(priority=3)
	public void verifyHealthInsuranceIconIsClickable() throws EncryptedDocumentException, IOException {
		logger=report.createTest("Verify Health Insurance Icon Is Clickable");
		String actualResult=lp.clickHealthInsuranceIcon(); 
		String expectedResult = FetchData.fromExcelSheet(1, 1);
		sa.assertEquals(actualResult, expectedResult);
		driver.navigate().back();
		System.out.println(actualResult+" :: "+ expectedResult);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
