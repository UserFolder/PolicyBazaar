package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomUtilities.Waits;

public class LandingPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//p[text()='Health']")
	private WebElement healthInsuranceIcon;
	
	@FindBy(xpath="//a[@class='view-all view-all-prd']")
	private WebElement viewAllProducts;
	
	
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
	
	public String clickHealthInsuranceIcon() throws InterruptedException {
		Waits.explicitWait(healthInsuranceIcon, driver, 0);
		healthInsuranceIcon.click();
		Thread.sleep(3000);
		String result=driver.getCurrentUrl();
		return result;
	}
	
	
	
}
