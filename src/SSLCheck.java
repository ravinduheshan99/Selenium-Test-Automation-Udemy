import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) {

		// Setting up browser behaviors
		// FirefoxOptions option2 = new FirefoxOptions();
		// EdgeOptions option3 = new EdgeOptions();
		ChromeOptions options = new ChromeOptions();

		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver","D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		// Accept Insecured Sites
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println("Page Title : " + driver.getTitle());
	}

}
