import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//type ind in the searchbox
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		//get allsuggestions given according to the search input
		List<WebElement> allSuggestions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//iterate the webelement list using foreach loop and click the expecting country
		allSuggestions.forEach(element->{
			if(element.getText().equals("India")) {
				element.click();
			}
		});

	}

}
