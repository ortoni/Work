package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnGetRect {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		//WebElement ele = driver.findElementByXPath("//h2");

		WebElement ele =driver.findElementByXPath("(//img)[2]");
		Rectangle rect = ele.getRect();
		//rect.getDimension();
		System.out.println(rect.getDimension());
		//Dimension d = rect.getDimension();
		/*System.out.println(d.height);
		System.out.println(d.width);*/
		
		/*System.out.println(rect.height);
		System.out.println(rect.width);*/
		/* System.out.println(rect.getHeight());
		 System.out.println(rect.getWidth());
		 System.out.println(rect.getX());
		 System.out.println(rect.getY());
*/		 driver.quit();
	}

}
