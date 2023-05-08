package testClasses;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pomClasses.QuotesPage1;
import testClassUtilities.FetchData;


public class QuotesPage1TestClass extends BaseClass{
	
	QuotesPage1 qp;
	SoftAssert sa;
	String quotePage1WindowAddress ;
	
	@BeforeClass
	public void initializingQuotesPage1Object() {
		qp = new QuotesPage1(driver);
		sa = new SoftAssert();
		quotePage1WindowAddress=qp.quotePage1WindowAddress();
		System.out.println("initializing QuotesPage1 Object......");
	}
	
	@Test(priority=1)
	public void verifyMaleCheckboxText() throws EncryptedDocumentException, IOException {
		logger=report.createTest("Verify the Male Checkbox Text");
		String actualResult = qp.checkMaleCheckboxText();
	    String expectedResult = FetchData.fromExcelSheet(3, 0);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult + "::" + expectedResult);
		sa.assertAll();
	}
	
	@Test(priority=2)
	public void verifyFemaleCheckboxText() throws EncryptedDocumentException, IOException {
		logger=report.createTest("Verify the Female Checkbox Text");
		String actualResult = qp.checkFemaleCheckboxText();
	    String expectedResult = FetchData.fromExcelSheet(5, 0);
		sa.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult + "::" + expectedResult);
		sa.assertAll();
	}
	
	@Test(priority=3)
	public void verifyClickabilityOfFemaleCheckbox() {
		logger=report.createTest("Verify the Clickability Of Female Checkbox");
		qp.clickFemaleCheckbox();
		sa.fail("Test Case was intentionally Failed, Check Screenshot Attached for respective Test Case");
		sa.assertAll();
	}
	
	@Test(priority=4)
	public void verifyClickabilityOfMaleCheckbox() {
		logger=report.createTest("Verify the Clickability Of Male Checkbox");
		qp.clickMaleCheckbox();
		qp.clickMaleCheckbox();
		sa.fail("Test Case was intentionally Failed, Check Screenshot Attached for respective Test Case");
		sa.assertAll();
	}
	
	@Test(priority=5)
	public void verifyTextOfYourFullNameLabel() throws EncryptedDocumentException, IOException {
		logger=report.createTest("Verify the Text Of Your Full Name Label");
		String actualResult= qp.checkyourFullNameLabelText();
		String expectedResult = FetchData.fromExcelSheet(6, 0);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult+"::"+expectedResult);
	}
	
	@Test(priority=6)
	public void verifyYourFullNameLabelByPassingBlankText() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Verify Your Full Name Label By Passing Blank Text");
		String actualErrorText = qp.checkyourFullNameLabelByPassingBlankText(FetchData.fromExcelSheet(4, 0));
		String expectedErrorText = FetchData.fromExcelSheet(7, 0);
		System.out.println(actualErrorText+"::"+expectedErrorText);
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	

	@Test(priority=7)
	public void verifyYourFullNameLabelByPassingText() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Verify the Your Full Name Label By Passing Text(Only ALPHABATES)");
		qp.checkyourFullNameLabelByPassingText(FetchData.fromExcelSheet(9, 0));
		qp.clickContinueButton();
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		driver.navigate().back();		
		String expectedURL = FetchData.fromExcelSheet(3, 1);	
		sa.assertEquals(actualURL, expectedURL);
		System.out.println(actualURL+"::"+expectedURL);
	}
	
	@Test(priority=8)
	public void verifyTextOfContinueButton() throws EncryptedDocumentException, IOException {
		logger=report.createTest("Verify the Text Of Continue Button");
		String actualResult= qp.checkContinueButtonText();
		String expectedResult = FetchData.fromExcelSheet(8, 0);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println(actualResult+"::"+expectedResult);
	}
	
	@Test(priority=9)
	public void verifyClickabilityOfContinueButton() throws InterruptedException, EncryptedDocumentException, IOException {
		logger=report.createTest("Verify the Clickability Of Continue Button");
		qp.checkyourFullNameLabelByPassingText(FetchData.fromExcelSheet(9, 0));
		qp.clickContinueButton();
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = FetchData.fromExcelSheet(3, 1);
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println(actualURL+"  ::  "+expectedURL);
		driver.navigate().back();
	}
	
	@Test(priority=10)
	public void veirifyPrivacyPolicyIsDisplayed() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Veirify if Privacy Policy is Displayed");
		Thread.sleep(2000);
		boolean actualResult= qp.checkPrivacyPolicyisDisplayed();
        System.out.println("Privacy Policy Icon Displayed = "+actualResult);
        Assert.assertTrue(actualResult);
	}
	
	@Test(priority=11)
	public void verifyClickabilityOfPrivacyPolicy() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Verify the Clickability Of PrivacyPolicy");
		qp.checkClickabilityOfPrivacyPolicy();
		Thread.sleep(2000);
		String expectedURL = FetchData.fromExcelSheet(4, 1);
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL+"::"+expectedURL);
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority=12)
	public void verifyTermsOfUseIsDisplayed() throws EncryptedDocumentException, IOException, InterruptedException {
		
		logger=report.createTest("Verify if Terms of Use is Displayed");
  	    driver.switchTo().window(quotePage1WindowAddress);
  	    Thread.sleep(2000);
		boolean actualResult = qp.checkTermsOfUseIsDisplayed();
		System.out.println("Terms of Use is Displayed = "+actualResult);
        Assert.assertTrue(actualResult);
	}
	
	@Test(priority=13)
	public void verifyClickabilityOfTermsOfUse() throws EncryptedDocumentException, IOException, InterruptedException {
		logger=report.createTest("Verify the Clickability Of Terms of Use");
		String actualURL=qp.checkClickabilityOfTermsOfUse(); 
		String expectedURL = FetchData.fromExcelSheet(5, 1);
		sa.assertEquals(actualURL, expectedURL);
		System.out.println(actualURL+"  ::  "+expectedURL);
		sa.assertAll();
	}
	
	@Test(priority=14)
	public void navigateBackToQuotePage1URL() throws InterruptedException, EncryptedDocumentException, IOException {
		logger=report.createTest("Navigate Back To QuotePage1 URL");
        driver.switchTo().window(quotePage1WindowAddress);
        Thread.sleep(5000);
        qp.checkyourFullNameLabelByPassingText(FetchData.fromExcelSheet(9, 0));
		qp.clickContinueButton();
		Thread.sleep(5000);
		System.err.println("Failed Test Case Priority No. =3, 4, 11, 13");
	}
	
	
	
	
	
	
	
	
	
}
