package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RectLearn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement ele = driver.findElementByCssSelector("div#draggable");
		Rectangle rect = ele.getRect();
		System.out.println(rect.getDimension());
		//System.out.println(rect.getHeight());
	}

}
