import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dropdown with select tag
		//get the dropdown as a web element
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select dropdown = new Select(staticDropdown);
		//select using index
		dropdown.selectByIndex(3);
		//print the current visible selected option
		System.out.println("Selected web element : "+dropdown.getFirstSelectedOption().getText());
		//select option by hard coding the known values
		dropdown.selectByVisibleText("AED");
		System.out.println("Selected web element : "+dropdown.getFirstSelectedOption().getText());
		//select using value attribute in the element
		dropdown.selectByValue("INR");
		System.out.println("Selected web element : "+dropdown.getFirstSelectedOption().getText());

	}

}
