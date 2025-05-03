import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the PDF to JPG conversion website
        driver.get("https://www.ilovepdf.com/pdf_to_jpg");

        // Click the file picker button to upload a file
        driver.findElement(By.id("pickfiles")).click();
        
        // Wait to allow OS-level file upload dialog to appear
        Thread.sleep(3000);
        
        // Deprecated method: Using Runtime.getRuntime().exec() is discouraged in modern Java due to limited control and error handling
        // Use ProcessBuilder instead for better flexibility and management
        // Runtime.getRuntime().exec("D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\Introduction\\fileUpload.exe");
        
        // Use ProcessBuilder to run the AutoIT script for file upload
        ProcessBuilder pb = new ProcessBuilder("D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\Introduction\\fileUpload.exe");
        pb.start();

        // Confirm successful execution
        System.out.println("Successfully Uploaded the File");
	}
}
