import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		// Create an instance of the Actions class, which allows us to perform complex user gestures
        Actions a = new Actions(driver);
        // Move the mouse to the "Account & Lists" menu item by locating it via its ID, and perform the action
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();

	}

}
