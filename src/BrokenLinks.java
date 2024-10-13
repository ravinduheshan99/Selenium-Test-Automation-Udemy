import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Checking for broken links
        // Step (01): Get all URLs tied to the links on the page using Selenium
        // Using cssSelector to find all <a> elements inside <li> elements with class 'gf-li'
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        
        // Using SoftAssert to allow multiple assertions to be performed
        // SoftAssert allows the program to continue running even if an assertion fails
        SoftAssert softAssert = new SoftAssert();
        
        // Loop through each link found on the page
        for(WebElement link : links) {
            
            // Get the URL (href attribute) from each link element
            String url = link.getAttribute("href");
            
            // Open a connection to the URL to check its response code
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");  // Use the HEAD method to get only headers, no body
            con.connect();  // Connect to the URL
            
            // Get the HTTP response code (e.g., 200 for success, 404 for not found)
            int respCode = con.getResponseCode();
            
            // Print the response code for debugging purposes
            System.out.println(respCode);
            
            // Using SoftAssert to verify the response code
            // If the response code is >= 400, it indicates a broken link
            // SoftAssert will collect all failures and only report them after all checks are done
            softAssert.assertTrue(respCode < 400, "The link with text : " + link.getText() + " is a broken link with code: " + respCode);
        }
        
        // This will trigger the SoftAssert to report all failures collected during the loop
        softAssert.assertAll();
			
	}

}
