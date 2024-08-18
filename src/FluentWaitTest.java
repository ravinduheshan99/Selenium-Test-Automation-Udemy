import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		// Click the start button to initiate the dynamic content loading
		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		// Set up a FluentWait instance with a timeout of 30 seconds and polling interval of 3 seconds
		Wait<WebDriver> wait = new FluentWait<>(driver)
							   .withTimeout(Duration.ofSeconds(30))       // Maximum time to wait for the condition to be true
				               .pollingEvery(Duration.ofSeconds(3))       // Check for the condition every 3 seconds
				               .ignoring(NoSuchElementException.class);  // Ignore NoSuchElementException while waiting

		// Define the condition for FluentWait - wait until the specified element is visible
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				// Locate the element that should appear after loading
				WebElement element = driver.findElement(By.cssSelector("[id='finish'] h4"));

				// If the element is displayed, return it; otherwise, return null to keep waiting
				if (element.isDisplayed()) {
					return element;
				} else {
					return null;  // Returning null will continue the wait loop
				}
			}
			
		});

		// Output the text content of the element once it is found and displayed
		System.out.println("Final Text : " + foo.getText());

		// No need to quit the driver in this example, but in a real scenario, add driver.quit() to close the browser
	}
}
