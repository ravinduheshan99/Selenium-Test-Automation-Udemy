import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingTwoWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Open a new tab within the same browser session
		// Get the set of window handles (IDs for each browser window or tab opened)
		// Create an iterator to cycle through the window handles
		driver.switchTo().newWindow(WindowType.TAB); 
		//driver.switchTo().newWindow(WindowType.WINDOW); -to open in a new window instead of tab 
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		//Store the first window handle as the parent window ID
		//Store the second window handle as the child window ID
		String parentWindowId = it.next();
		String childWindowId = it.next();

		// Switch to the newly opened tab (child window)
		// Open a different URL in the child window
		// Locate the course link element by partial URL match and get the text of the
		// second element found
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

		// Switch back to the parent window
		// Find the name input field in the parent window and enter the course name
		// retrieved from the child window
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.name("name")).sendKeys(courseName);
	}

}
