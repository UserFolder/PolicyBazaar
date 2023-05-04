package testClassUtilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	
	public static String takeSS(WebDriver driver) throws IOException {
		
		String path ="C:"+File.separator+"Users"+File.separator+"Rajat Dhawade"+File.separator+"eclipse-workspace"+File.separator+"Bazaar"+File.separator+"test-output"+File.separator+"Screenshots"+System.currentTimeMillis()+".png";
		
		TakesScreenshot t = (TakesScreenshot)driver;
		
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(src, dest);
		return path;
		
	}
}
