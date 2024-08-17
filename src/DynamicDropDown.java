import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// //a[@value='MAA'] -> xpath for chennai
		// //a[@value='BLR'] -> xpath for bengaluru 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		//select departure city using xpath
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//add thread sleep to avoid synchronization errors
		Thread.sleep(2000);
		//select arrival city using xpath
		//since this is dynamic dropdown, add indexing because initially there are two elements belongs to //a[@value='MAA'] xpath
		//to skip 1st appeared element we use index 2 we need the xpath of chennai in second dropdown
		
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//instead of using index for selecting arrival city we can use parent child relationship of xpaths
		driver.findElement(By.xpath("(//div[@class='dropdownDiv'] //a[@value='MAA'])[2]")).click();
		//select the current date using cssSelector
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//select future date will be discussing in coming sessions

	}

}
