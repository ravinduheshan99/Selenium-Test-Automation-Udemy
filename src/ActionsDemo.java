import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		// Maximize the browser window for better visibility
        driver.manage().window().maximize();
        // Create an instance of the Actions class to perform complex user interactions
        Actions a = new Actions(driver);
        // Locate the "Account & Lists" menu item by its ID and store it in a WebElement
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        // Perform a mouse hover over the "Account & Lists" menu item
        a.moveToElement(move).build().perform();
        // Locate the search box by its ID, click on it, hold down the SHIFT key, and type "hello" in uppercase
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

	}

}
