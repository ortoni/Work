package challengeDemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Myntra {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
/*		options.setHeadless(true);
*/		ChromeDriver driver = new ChromeDriver(/*options*/);	
		
		driver.manage().window().maximize();	 
		driver.get("https://www.myntra.com/accessories?f=categories%3ASunglasses%3A%3Adiscount%3A20.0");
		
		List<WebElement> discounts = driver.findElementsByClassName("product-discountPercentage");
		List<WebElement> products =  driver.findElementsByClassName("product-brand");
		for (int i = 0; i < discounts.size(); i++) {
			String discountPercentage = discounts.get(i).getText().replaceAll("\\D", "");
			System.out.println(discountPercentage);
			if(discountPercentage.equals("50")){
				System.out.println(products.get(i).getText());
			}
		}
		
		
	}
}


































