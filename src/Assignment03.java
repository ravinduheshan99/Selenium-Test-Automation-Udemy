import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment03 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String username = driver.findElement(By.xpath("//i[text()='rahulshettyacademy']")).getText();
		String password = driver.findElement(By.xpath("//i[text()='learning']")).getText();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//label[@class='customradio'])[2]/span[@class='checkmark']")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']")));
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();

		WebElement elements = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdownItems = new Select(elements);
		dropdownItems.selectByVisibleText("Consultant");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[text()='iphone X']")));
		String[] itemsNeeded = {"iphone","Samsung","Nokia","Blackberry"};
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		//take all the web elements which contains product names
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		//to stop the loop going extra iterations after find all items
		int j=0;

		for(int i=0; i<products.size(); i++) {
			//split item name form "-" and get the name only and trim it to remove whitespaces-->(Cucumber - 1Kg)---->(Cucumber)
			String prodName = products.get(i).getText().split(" ")[0];
			//convert array into arraylist for easyuse of contains method
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(prodName)) {
				//instead of using text() we use class because text can be change time to time
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				j++;
			}

			if(j==itemsNeeded.length) {
				break;
			}
		}

	}

}
