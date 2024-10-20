import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test02_stream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Career\\My Projects\\Selenium Projects\\01-Introduction-Project\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all the webelements into list
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		//capture text of all webelements into new(original) list
		List<String> itemNames = items.stream().map(s->s.getText()).collect(Collectors.toList());
		//apply sort on the original list of step 3->sorted list
		List<String> sortedItemNames = itemNames.stream().sorted().collect(Collectors.toList());
		//compare original list vs sorted list
		Assert.assertTrue(itemNames.equals(sortedItemNames));
		
		//scan the name column and if we getText -> Beans-> print the price of the Beans
		List<String> price = items.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println("price of the Beans : "+s));
		
		List<String> price2;
		List<WebElement> items2;  
		
		do{
			//scan the name column and if we getText -> Rice-> print the price of the Rice
			items2 = driver.findElements(By.xpath("//tr/td[1]"));
			price2 = items2.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			
			if(price2.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
			
		}while(price2.size()<1);
		
		price2.forEach(s->System.out.println("price of the Rice : "+s));
	}
	
	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}
