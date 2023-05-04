package testClasses;

import pomClasses.LandingPage;
import testClassUtilities.FetchData;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LandingPageTestClass extends BaseClass{
	
	LandingPage lp ;

	@BeforeClass
	public void initializingLandingPageObject() {
		lp = new LandingPage(driver);	
	}
	
	@Test
	public void verifyHealthInsuranceIconIsDisplayed() {
		boolean actualResult=lp.checkHealthInsuranceIconIsDisplayed();
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void verifyHealthInsuranceIconText() throws EncryptedDocumentException, IOException {
		String actualResult=lp.checkHealthInsuranceIconText();
		String expectedResult=FetchData.fromExcelSheet(0, 0);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void verifyHealthInsuranceIconIsClickable() {
		lp.clickHealthInsuranceIcon();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
