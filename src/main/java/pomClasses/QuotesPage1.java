package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtilities.Waits;

public class QuotesPage1 {
	
	WebDriver driver;
	
	@FindBy(xpath="//label[@for='male']")
	private WebElement maleCheckbox;
	
	@FindBy(xpath="//label[@for='female']")
	private WebElement femaleCheckbox;

	@FindBy(xpath="//label[@for='fullName']")
	private WebElement yourFullNameLabel;
	
	@FindBy(xpath="//input[@id='fullName']")
	private WebElement yourFullNameInput;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//small[@class='text-error']")
	private WebElement errorMessage;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//a[contains(text(),'Terms of Use')]")
	private WebElement termsOfUse;
	
	@FindBy(xpath="//h1[contains(text(),'Legal And Admin Policies')]")
	private WebElement legalAndAdminPolicies;                                                                        	
	
	
	
	public QuotesPage1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);;
	}
	
	
	
	
	public String quotePage1WindowAddress() {
	    String quotePage1Address = driver.getWindowHandle();
		return quotePage1Address;
	}
	
	public String checkMaleCheckboxText() {
		Waits.explicitWait(maleCheckbox, driver, 5);
		String result = maleCheckbox.getText();
		return result;	
	}
	
	public String checkFemaleCheckboxText() {
		Waits.explicitWait(femaleCheckbox, driver, 5);
		String result = femaleCheckbox.getText();
		return result;
	}
	
	public void clickFemaleCheckbox() {
		femaleCheckbox.click();
	}
	
	public void clickMaleCheckbox() {
		maleCheckbox.click();
	}

	public String checkyourFullNameLabelText() {
		Waits.explicitWait(yourFullNameLabel, driver, 5);
		String result = yourFullNameLabel.getText();
		return result;
	}
	
	public String checkyourFullNameLabelByPassingBlankText(String blank) {
		yourFullNameInput.sendKeys(blank);
		continueButton.click();
		Waits.explicitWait(errorMessage, driver, 5);
		String  result=errorMessage.getText();
		return result;
	}
	
	public boolean checkErrorMessageDisplayedWithPassingBlankTextInYourFullNameLabel() {
		Waits.explicitWait(errorMessage, driver, 5);
		boolean result = errorMessage.isDisplayed();
		return result;	
	}
	
	public String checkErrorMessageTextWithPassingBlankTextInYourFullNameLabel() {
		Waits.explicitWait(errorMessage, driver, 5);
		String result = errorMessage.getText();
		return result;
	}
	
	public void checkyourFullNameLabelByPassingText(String text) {
		Waits.explicitWait(yourFullNameInput, driver, 5);
		yourFullNameInput.clear();
		yourFullNameInput.sendKeys(text);
	}
	
	public String checkContinueButtonText() {
		Waits.explicitWait(continueButton, driver, 5);
		String result = continueButton.getText();
		return result;
	}

	public void clickContinueButton() {
		Waits.explicitWait(continueButton, driver, 5);
		continueButton.click();
	}
	
	public boolean checkPrivacyPolicyisDisplayed() {
		Waits.explicitWait(privacyPolicy, driver, 5);
		boolean result = privacyPolicy.isDisplayed();
		return result;
	}
	
	public void checkClickabilityOfPrivacyPolicy() {
		Waits.explicitWait(privacyPolicy, driver, 5);
		privacyPolicy.click();
	}
	
	public boolean checkTermsOfUseIsDisplayed() {
		Waits.explicitWait(termsOfUse, driver, 5);;
		boolean result = termsOfUse.isDisplayed();
	    return result;
	}
	
	public String checkClickabilityOfTermsOfUse() {
		Waits.explicitWait(termsOfUse, driver, 5);
		termsOfUse.click();
		String urlTermsOfUse =driver.getCurrentUrl();
		return urlTermsOfUse;
	}
	
	public boolean checkLegalAndAdminPoliciesIsDisplayed() {
		Waits.explicitWait(legalAndAdminPolicies, driver, 5);
		boolean result=legalAndAdminPolicies.isDisplayed();
		return result;
	}

}
