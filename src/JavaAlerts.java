import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//insert input text in the textfield
		driver.findElement(By.id("name")).sendKeys("Ravindu");
		//click the alert generation button
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		//get the text inside the alert
		System.out.println("Alert text is : "+driver.switchTo().alert().getText());
		//searching the alerts generated in the page and accept it by clicking ok
		driver.switchTo().alert().accept();

		//insert input text in the textfield
		driver.findElement(By.id("name")).sendKeys("Ravindu");
		//click the confirm alert generation button
		driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
		//get the text inside the alert
		System.out.println("Alert text is : "+driver.switchTo().alert().getText());
		//when alert occurs whis options like ok,cancel this can use to select cancel
		driver.switchTo().alert().dismiss();

	}

}
