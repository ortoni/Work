package sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWeb {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		System.out.println(driver.getTitle());
		System.out.println(driver.getSessionId());
		String src = driver.getPageSource();
		//System.out.println(src);
		System.out.println(src.contains("Our long-time"));
		//FileDetector file = driver.getFileDetector();
		//driver.getClass();
		
	    WebElement a  = driver.findElementById("username");
	    String b = a.getAttribute("type");
	    System.out.println(b);
	  
	    System.out.println( b.getClass());
		driver.close();
		
	}
}
