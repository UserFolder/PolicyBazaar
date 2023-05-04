package testClassUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Waits {
	
	public static WebDriver implicitWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		return driver;
	}

}
