import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		//since there are two windows are opened ----> [parentid,childid] will be the stored value for window variable
		//if there are three windows are opened ----> [parentid,childid,subchildId] will be the stored value for window variable
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> it = windows.iterator();
		String parentId =  it.next();
		String childId =  it.next();
		driver.switchTo().window(childId);
		
		System.out.println("Text Block We Need To Catch : "+driver.findElement(By.cssSelector("p.im-para.red")).getText());
		System.out.println("Email Needed To Extract : "+driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0]);
		String username = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(username);

	}

}
