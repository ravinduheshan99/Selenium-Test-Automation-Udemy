import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshots {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Open a new window
		// Get the set of window handles (IDs for each browser window or tab opened)
		// Create an iterator to cycle through the window handles
		driver.switchTo().newWindow(WindowType.WINDOW); 
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
		// Find the name input field in the parent window and enter the course name retrieved from the child window
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		
		// Take a screenshot of the input field element and store it as a File object
		// Save the screenshot as a file named "logo.png" in the current project directory
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//get height and width
		System.out.println("Height : "+name.getRect().getDimension().getHeight());
		System.out.println("Width : "+name.getRect().getDimension().getWidth());
	}

}
