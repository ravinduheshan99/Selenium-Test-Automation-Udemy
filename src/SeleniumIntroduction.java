import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {

		//Invoking Browser
		//Firefox - FirefoxDriver -> Methods
		//Safari - SafariDriver -> Methods
		//Chrome - ChromeDriver -> Methods
		//WebDriver is the interface which all above classes are implemented from
		//Same method names coming from WebDriver Interface but different implementations for different browsers
		//can focus on both WebDriver methods + class methods

		//Method 01-Selenium Manger Will Handle
		ChromeDriver driver = new ChromeDriver();

		//Method 02-Selenium Manger Will Handle
		//Dynamic method dispatching to avoid to going object focus into the class methods instead of WebDriver methods
		WebDriver driver2 = new ChromeDriver();

		//Method 03-Selenium Manger Won't Handle
		//ChromeDriver.exe -> Chrome browser
		//Not Recommended
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver3 = new ChromeDriver();
	}

}
