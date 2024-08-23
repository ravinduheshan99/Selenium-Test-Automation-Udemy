import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");

		// Printing the total number of iframe elements on the page
		System.out.println("Total frame count in the page : " + driver.findElements(By.tagName("iframe")).size());

		// Switching to the iframe that contains the droppable demo using a CSS selector
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		// Creating an Actions object to perform drag-and-drop actions
		Actions a = new Actions(driver);
		// Locating the draggable element by its ID
		WebElement source = driver.findElement(By.id("draggable"));
		// Locating the droppable element by its ID
		WebElement target = driver.findElement(By.id("droppable"));

		// Performing the drag-and-drop action from the source element to the target element
		a.dragAndDrop(source, target).build().perform();

		// Switching back to the default content (main page) after interacting with the iframe
		driver.switchTo().defaultContent();

	}

}
