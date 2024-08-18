import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartSite {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Add implicit wait to proper synchronization in script---->works globally for every step
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		//create the array of items which needed to add to cart
		//arraylist use more memory than arrays
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
		
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		//Add explicit wait---->works only for this step
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println("Promocode Applying Status : "+driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
	

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		
		//take all the web elements which contains product names
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		//to stop the loop going extra iterations after find all items
		int j=0;

		for(int i=0; i<products.size(); i++) {
			//split item name form "-" and get the name only and trim it to remove whitespaces-->(Cucumber - 1Kg)---->(Cucumber)
			String prodName = products.get(i).getText().split("-")[0].trim();
			//convert array into arraylist for easyuse of contains method
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(prodName)) {
				//instead of using text() we use class because text can be change time to time
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				j++;
			}

			if(j==itemsNeeded.length) {
				break;
			}
		}
		
	}

}
