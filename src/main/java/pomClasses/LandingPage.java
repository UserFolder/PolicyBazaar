package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtilities.Waits;

public class LandingPage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")
	private WebElement healthInsuranceIcon;
	
	@FindBy(xpath="//a[contains(text(),'View all products')]")
	private WebElement viewAllProducts;
	
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg health-insurance'])[1]")
	private WebElement alertHealthInsuranceIcon;
	
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);;
	}
	
	
	
	public boolean checkHealthInsuranceIconIsDisplayed() {
		Waits.explicitWait(healthInsuranceIcon, driver, 0);
		boolean result =healthInsuranceIcon.isDisplayed();
		return result;
	}
	
	public String checkHealthInsuranceIconText() {
		Waits.explicitWait(healthInsuranceIcon, driver, 0);
		String result=healthInsuranceIcon.getText();
		return result;
	}
	
	public String clickHealthInsuranceIcon() {
		Waits.explicitWait(healthInsuranceIcon, driver, 0);
		healthInsuranceIcon.click();
		String result=driver.getCurrentUrl();
		return result;
	}
	
	public boolean checkViewAllProductsButtonIsDisplayed() {
		Waits.explicitWait(viewAllProducts, driver, 5);
		boolean result=viewAllProducts.isDisplayed();
		return result;
		
	}
	
	public String checkViewAllProductsButtonText() {
		Waits.explicitWait(viewAllProducts, driver, 5);
		String result=viewAllProducts.getText();
		return result;
	}
	
	public void clickViewAllProductsButton() {
		Waits.explicitWait(viewAllProducts, driver, 5);
		viewAllProducts.click();
	}

	public boolean checkAlertHealthInsuranceIconIsDisplayed() {
		Waits.explicitWait(alertHealthInsuranceIcon, driver, 5);
		boolean result=alertHealthInsuranceIcon.isDisplayed();
		return result;
	}
	
	public String checkAlertHealthInsuranceIconText() {
		Waits.explicitWait(alertHealthInsuranceIcon, driver, 5);
		String result=alertHealthInsuranceIcon.getText();
		return result;
	}
	
	public String clickAlertHealthInsuranceIconText() {
		Waits.explicitWait(alertHealthInsuranceIcon, driver, 5);
		alertHealthInsuranceIcon.click();
		String result=driver.getCurrentUrl();
		return result;
	}
	
	
}
