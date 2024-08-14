import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait -5 seconds timeout until load the error message to the page and avoid cssSelector not found errors 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//providing correct username and incorrect password to check whether it is indicating error message
		driver.findElement(By.id("inputUsername")).sendKeys("ravinduheshan");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//there are two classes assigned for the sign in button among those two "signInBtn" class is more unique for that element
		driver.findElement(By.className("signInBtn")).click();
		//use cssSelector to get the error message due to wrong password
		System.out.println("Error Log : "+driver.findElement(By.cssSelector("p.error")).getText());
		//use linkText locator to navigate to the forget password page
		driver.findElement(By.linkText("Forgot your password?")).click();
		//use xpath locator to fill new username field
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("heshanhaputhanthri");
		

	}

}
