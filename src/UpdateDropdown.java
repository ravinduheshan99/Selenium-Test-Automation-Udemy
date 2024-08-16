import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("divpaxinfo")).click();
		//to avoid synchronization errors
		Thread.sleep(2000);

		//to click two times to increase adult count
		for(int i=0; i<2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Selected adult count : "+driver.findElement(By.id("divpaxinfo")).getText());

	}

}
