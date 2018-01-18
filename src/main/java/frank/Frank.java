package frank;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Frank {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "63.0");
		//caps.setCapability("screenResolution", "1280x1024");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ortoni10:b8114245-1e55-4914-b760-655b6dbcd06c@ondemand.saucelabs.com:80/wd/hub"), caps);

		/*System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.franklintempletonindia.com/");
		Thread.sleep(5000);
		driver.findElementById("distributor-zone").click();
	}

}
