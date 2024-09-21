import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;  // Correct import

public class SSLCheck {

    public static void main(String[] args) {

        // Setting up ChromeOptions for browser behavior
        ChromeOptions options = new ChromeOptions();

        // Add the WebDriver proxy capability using Selenium's Proxy class
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");  // Define the proxy
        options.setCapability("proxy", proxy);
        
        // To accept insecure SSL certs
        options.setAcceptInsecureCerts(true);  
        
     
        // These preferences allow us to customize the browser's behavior, such as changing the download directory.
        Map<String, Object> prefs = new HashMap<String, Object>();
        // Set the browser's default download directory to a specified path.
        // Replace "/directory/path" with the actual path where you want the files to be downloaded.
        prefs.put("download.default_directory", "/directory/path");
        // Apply the preferences to the ChromeOptions object.
        // This is necessary for the WebDriver to use the custom preferences when launching the browser.
        options.setExperimentalOption("prefs", prefs);
        
        System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        
        System.out.println("Page Title : " + driver.getTitle());
    }
}
