import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Assert;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//check using assertfalse whether the checkbox is selected
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//use regx and cssSelector to catch the checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//check the selection status of expected checkbox
		System.out.println("Is checkbox selected : "+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//check using asserttrue whether the checkbox is selected
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//count the number of checkboxes
		System.out.println("Number of checkboxes : "+driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		//to avoid synchronization errors
		Thread.sleep(2000);

		//to click two times to increase adult count
		for(int i=0; i<2; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult");
		System.out.println("Selected adult count : "+driver.findElement(By.id("divpaxinfo")).getText());

	}

}
