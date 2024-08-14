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

		//Method 03-Selenium Manger Won't Handle
		//webdriver.chrome.driver->value of path
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com");
		
		System.out.println("Title of the page is : "+driver.getTitle());
		System.out.println("Current URL of the page is : "+driver.getCurrentUrl());
		
		//only close the current window 
		driver.close();
		//close all the windows associated with current window
		driver.quit();
		
		
		
		
	}

}