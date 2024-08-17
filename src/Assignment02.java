import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment02 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/angularpractice");
		
		driver.findElement(By.name("name")).sendKeys("Ravindu Haputhanthi");
		driver.findElement(By.name("email")).sendKeys("ravinduheshan99@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ravindu123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement Elements = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(Elements);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12/06/1999");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
		
	}

}
