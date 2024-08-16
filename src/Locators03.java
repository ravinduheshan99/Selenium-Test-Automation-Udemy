import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators03 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Sibling - Parent traverse
		// /html/body/header <----absolute xpath - starting from the begining
		// //header/div/button[1] <----relative xpath - starting from the header
		// //header/div/button[1]/following-sibling::button[1]
		//Traverse from parent elements to child elements
		System.out.println("Button text : "+driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		// //header/div/button[1]/parent::div/button[2]
		//Traverse from child elements to parent elements
		System.out.println("Button text : "+driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

	}

}
