package sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FindElements {
	@Test()
	public void elements() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();	// Creating Object for ChromeDriver

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		driver.navigate().to("http://api.jqueryui.com/1.11/category/effects/");
		
		
		List<WebElement> cat = driver.findElementsById("categories");
		for (WebElement effects : cat) {
			System.out.println(effects.getText());
			
		}
		driver.close();
		
		}
}