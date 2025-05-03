import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class windowPopUpAutoIT {

	public static void main(String[] args) {
		
		// Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
        String messageToValidate = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.", messageToValidate);
        System.out.println("Meesage to validate : "+messageToValidate);
	}

}
