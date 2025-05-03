import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");

        // Set file download path to current working directory
        String downloadPath = System.getProperty("user.dir");
        
        // Configure Chrome preferences to auto-download without popups
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadPath);
        
        // Apply preferences to ChromeOptions
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("prefs", chromePrefs);
        
        // Launch Chrome browser with custom options
        WebDriver driver = new ChromeDriver(chromeOptions);
        
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

        // Confirm successful file upload
        System.out.println("Successfully Uploaded the File");
        
        // Wait for convert button to be clickable, then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement convertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("processTaskTextBtn")));
        convertButton.click();
        
        // Confirm successful file conversion
        System.out.println("Successfully Converted the File");
        
        // Wait for download button to be clickable, then click it
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("pickfiles")));
        downloadButton.click();
        
        // Wait to allow file to download
        Thread.sleep(4000);
        
        // Check if the downloaded file exists in the specified path
        File file = new File(downloadPath + "/ilovepdf_pages-to-jpg.zip");
        
        // Assert file existence using TestNG
        Assert.assertTrue(file.exists());
        
        if(file.exists()) {
        	System.out.println("Successfully Downloaded the File");
        	
        	// Delete file after validation
        	if(file.delete()) {
        		System.out.println("File Deleted Successfully After Validation");
        	}
        } else {
        	System.out.println("File Downloading Unsuccessful");
        }
        
        // Close browser
        driver.close();
	}
}
