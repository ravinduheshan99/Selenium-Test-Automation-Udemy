import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellneanous {
	
	public static void main(String[] args) {
		
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
	}

}
