package sample;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class FindElementsById {
	@Test
	public void elements() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();	// Creating Object for ChromeDriver
		
		driver.navigate().to("http://api.jqueryui.com/1.11/category/effects/");
		List<WebElement> cat = driver.findElementsById("categories");
		for (WebElement effects : cat) {
			System.out.println(effects.getText());
			
		}
		driver.close();
		
	}
}