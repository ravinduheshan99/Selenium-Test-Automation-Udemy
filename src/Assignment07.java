import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment07 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		WebElement table = driver.findElement(By.id("product"));
		System.out.println("Number of Rows : "+table.findElements(By.tagName("tr")).size());
		System.out.println("Number of Columns : "+table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println("Second Row Data");
		System.out.print(secondRow.get(0).getText()+"||"+secondRow.get(1).getText()+"||"+secondRow.get(2).getText());
	}

}
