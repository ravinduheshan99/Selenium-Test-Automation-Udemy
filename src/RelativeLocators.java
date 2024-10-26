import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox =  driver.findElement(By.name("name"));
		System.out.println("Label name above name text field : "+driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement dobLabel =  driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
		
		WebElement checkboxText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxText)).click();
		
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println("Label name of the radio button is : "+driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
	}

}
