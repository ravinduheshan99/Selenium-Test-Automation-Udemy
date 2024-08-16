import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// recommended to go with maximize without fullscreen
		//open in maximize screen mode
		driver.manage().window().maximize();
		driver.get("https://google.com");
		//navigate to another page
		driver.navigate().to("http://rahulshettyacademy.com");
		//move back
		driver.navigate().back();
		//move forward
		driver.navigate().forward();
	}

}
