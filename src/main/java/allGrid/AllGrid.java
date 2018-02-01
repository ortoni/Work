package allGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AllGrid {
	@Test
	public void gridEdge() throws MalformedURLException{
		DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("platform", "macOS 10.12");
		caps.setCapability("version", "11.0");		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http://192.168.121.255:4444/wd/hub"), caps);
		driver.get("https://www.google.com");
	}
	
/*	@Test
	public void gridEdge() throws MalformedURLException{
		//System.setProperty("webdriver.edge.driver", "./driver/edge.exe");
		//new DesiredCapabilities();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("MicrosoftEdge");
		dc.setPlatform(Platform.WINDOWS);		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http://192.168.1.32:4444/wd/hub"), dc);
		driver.get("https://www.google.com");
	}
	@Test
	public void gridFox() throws MalformedURLException{
		//System.setProperty("webdriver.edge.driver", "./driver/edge.exe");
		//new DesiredCapabilities();
		DesiredCapabilities dc = new DesiredCapabilities();
		//dc.setBrowserName("MicrosoftEdge");
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http://192.168.1.32:4444/wd/hub"), dc);
		driver.get("https://www.google.com");
	}

	@Test
	public void gridChrome() throws MalformedURLException{
		//System.setProperty("webdriver.edge.driver", "./driver/edge.exe");
		//new DesiredCapabilities();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http://192.168.1.32:4444/wd/hub"), dc);
		driver.get("https://www.google.com");
	}
*/}
