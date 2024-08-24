import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. Give me the count of links on the page
		System.out.println("Links count on the page : "+driver.findElements(By.tagName("a")).size());
		
		// 2. Give me the count of links on the footer
		//Limiting webdriver scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Links count on the footer : "+footerDriver.findElements(By.tagName("a")).size());
		
		// 3. Give me the count of links in first column on the footer
		WebElement columnDriver =  footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Links count on the first column in the footer : "+columnDriver.findElements(By.tagName("a")).size());
		
		// 4. Click on each link in the column and check if the pages are opening
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		}
		
		// 5. Get the titles from each page by navigating through parent and child windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		int j=1;
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Title of Page Number "+j+" is : "+driver.getTitle());
			j++;
		}
		
	}

}
