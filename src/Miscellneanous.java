import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellneanous {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Maximizing the browser window to ensure elements are visible for interaction
        driver.manage().window().maximize();
        
        // Deleting all cookies to ensure a clean browser session
        driver.manage().deleteAllCookies();
        
        // Optionally, you could delete a specific cookie if needed
        // Example: delete a session cookie named "sessionKey"
        // driver.manage().deleteCookie("sessionKey");
        
        // Navigating to a specific webpage (in this case, Google's homepage)
        driver.get("http://google.com");
        
        // Capturing a screenshot of the current browser window
        // TakesScreenshot is an interface that allows the WebDriver to take a screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        // Saving the screenshot to a specified file location on the disk
        // Using FileUtils.copyFile to copy the screenshot to the desired path
        FileUtils.copyFile(src, new File("D://Documents//Career//My Projects//Selenium Projects//01-Introduction-Project//Introduction//Screenshots//screenshot01.png"));
        
        // This will save the screenshot as "screenshot01.png" in the specified folder
	}

}
