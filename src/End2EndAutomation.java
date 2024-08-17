import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2EndAutomation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//Section 01 - Auto Suggestive Dropdown
		
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
		
		//Section 02 - Departure and Arrival City Selection

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		//select departure city using xpath
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		//add thread sleep to avoid synchronization errors
		Thread.sleep(2000);
		//instead of using index for selecting arrival city we can use parent child relationship of xpaths
		driver.findElement(By.xpath("(//div[@class='dropdownDiv'] //a[@value='MAA'])[2]")).click();
		
		//Section 03 - Depart and Return Date Selection
		
		//select the current date using cssSelector
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//since the default radio button which selected is oneway button
		//so return date calendar should be disabled
		//if it's enabled without selecting round trip test should fail
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("display: block; opacity: 1;")) {
			System.out.println("Return date calendar is enabled");
			Assert.assertTrue(false);
		}else {
			System.out.println("Return date calendar is disabled");
			Assert.assertTrue(true);
		}
		
		//Section 04 - Passenger Count Adding
		
		//identify passenger element using id and click it
		driver.findElement(By.id("divpaxinfo")).click();
		//to avoid synchronization errors
		Thread.sleep(2000);
		//to click two times to increase adult count
		for(int i=0; i<3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
		System.out.println("Selected adult count : "+driver.findElement(By.id("divpaxinfo")).getText());

		//Section 05 - Currency Selection
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select dropdown = new Select(staticDropdown);
		//select option by hard coding the known values
		dropdown.selectByVisibleText("USD");

		//Section 06 - Checkbox Selection
		
		//check using assertfalse whether the checkbox is selected
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//use regx and cssSelector to catch the checkbox
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		//check using asserttrue whether the checkbox is selected
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		//Section 07 - Search For Flight by Submitting Details
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
