import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait -5 seconds timeout until load the error message to the page and avoid cssSelector not found errors 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//providing correct username and incorrect password to check whether it is indicating error message
		driver.findElement(By.id("inputUsername")).sendKeys("ravinduheshan");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//there are two classes assigned for the sign in button among those two "signInBtn" class is more unique for that element
		driver.findElement(By.className("signInBtn")).click();
		//use cssSelector to get the error message due to wrong password
		System.out.println("Error Log : "+driver.findElement(By.cssSelector("p.error")).getText());
		//use linkText locator to navigate to the forget password page
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//to avoid ElementClickInterceptedException in reset login button, we pause the thread for 1sec for it's transition
		//not recommended
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//use xpath locator to fill new username and email fields
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("heshanhaputhanthri");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("hapu@gmail.com");
		//when there's multiple elements with same xpath we can use index to uniquely identify the element that we want
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//when we want to use cssSelector with index we can use it like this
		//xpath index and cssSelector indexes can be differ due to hidden elements in the page
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("hapu@yahoo.com");
		//generating xpaths with parent to child tags traverse techniques
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0775165666");
		//another way of using cssSelector
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//generating cssSelector with parent to child tags traverse techniques
		System.out.println("Info Log : "+driver.findElement(By.cssSelector("form p")).getText());
		
		

	}

}
