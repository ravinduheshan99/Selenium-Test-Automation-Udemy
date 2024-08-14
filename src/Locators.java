import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//providing correct username and incorrect password to check whether it is indicating error message
		driver.findElement(By.id("inputUsername")).sendKeys("ravinduheshan");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//there are two classes assigned for the sign in button among those two "signInBtn" class is more unique for that element
		driver.findElement(By.className("signInBtn")).click();

	}

}
