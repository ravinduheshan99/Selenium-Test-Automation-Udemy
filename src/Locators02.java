import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators02 {

	public static void main(String[] args) {
		
		String name = "ravinduhaputhanthri";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait -5 seconds timeout until load the error message to the page and avoid cssSelector not found errors 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//use getPassword method to extract password from forget password window
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//providing correct username and incorrect password to check whether it is indicating error message
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//there are two classes assigned for the sign in button among those two "signInBtn" class is more unique for that element
		//if we use xpath for this scenario we have to use both classes //button[@class='submit signInBtn']
		driver.findElement(By.className("signInBtn")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		System.out.println("Actual matched with expected : "+driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		
		//compare the expected output with actual output using testng
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		//since there is one p tag we can use tagName locator
		System.out.println("Actual matched with expected : "+driver.findElement(By.tagName("p")).getText());
		
		//generating xpath based on the buttons text
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//generating cssSelector with parent to child tags traverse techniques
		//get the whole text appearing after click reset password button
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//splitting process of the password to extract actual password
		String[] firstPasswordArray = passwordText.split("'");
		//after splitting the string
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to Login.
		String[] secondPasswordArray = firstPasswordArray[1].split("'");
		//after splitting the string
		//0th index - rahulshettyacademy
		//1st index -  to Login.
		String actualPassword = secondPasswordArray[0];
		
		return actualPassword;
	
	}

}
