package pomUtilities;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Waits {
	
	public static WebDriverWait explicitWait(WebElement element , WebDriver driver, int duration) {
	
       WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(duration));
	   waits.until(ExpectedConditions.visibilityOf(element));
	   return waits;
	
	}
}
