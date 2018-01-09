package sample;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LearnDesiredCapabilities {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		/*ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);*/

		RemoteWebDriver driver = new ChromeDriver(/*opt*/);

		driver.manage().window().maximize();
	/*driver.get("http://www.google.com");

		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setJavascriptEnabled(true);
*/		
	/*	String baseUrl;
		baseUrl = "https://www.facebook.com";
	*/

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.XP);

		/*driver = new RemoteWebDriver(new URL(baseUrl),capability);*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
		driver.get("https://github.com/SeleniumHQ/selenium/issues/4979");
	

	}

}
