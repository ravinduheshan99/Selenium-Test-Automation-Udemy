import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test02_stream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all the webelements into list
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		//capture text of all webelements into new(original) list
		List<String> itemNames = items.stream().map(s->s.getText()).collect(Collectors.toList());
		//apply sort on the original list of step 3->sorted list
		List<String> sortedItemNames = itemNames.stream().sorted().collect(Collectors.toList());
		//compare original list vs sorted list
		Assert.assertTrue(itemNames.equals(sortedItemNames));

	}

}
