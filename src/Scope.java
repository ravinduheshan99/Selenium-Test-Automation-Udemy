import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. Give me the count of links on the page
		System.out.println("Links count on the page : "+driver.findElements(By.tagName("a")).size());
		
		//Limiting webdriver scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		// 2. Give me the count of links on the footer
		System.out.println("Links count on the footer : "+footerDriver.findElements(By.tagName("a")).size());
		
	}

}
