import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class Assignment06 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String checkboxText = driver.findElement(By.xpath("(//div[@id='checkbox-example']/fieldset/label)[2]")).getText();
		
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example")); 
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(checkboxText);
		
		driver.findElement(By.id("name")).sendKeys(checkboxText);
		
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		//System.out.println("alert text : "+alertText);
		//String extractedTextFromAlert = alertText.split(",")[0].split(" ")[1];
		//System.out.println("extracted alert text : "+extractedTextFromAlert);
		//Assert.assertEquals(checkboxText, extractedTextFromAlert);
		//driver.switchTo().alert().accept();
		if(alertText.contains(checkboxText)) {
			System.out.println("Alert Message Success");
		}else {
			System.out.println("Something Wrong With Execution");
		}
		driver.switchTo().alert().accept();

	}

}
