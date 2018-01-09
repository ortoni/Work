package allGrid;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FireFox58 {
	@Test
	public void fox() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "./driver/gecko.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addArguments("-private");
		FirefoxDriver driver = new FirefoxDriver(op);
		FirefoxProfile profile = op.getProfile();
		System.out.println(profile);
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.close();
	}
	@Test
	public void edge() throws InterruptedException{
		System.setProperty("webdriver.edge.driver", "./driver/edge.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.close();

	}@Test
	public void ie() throws InterruptedException{
		System.setProperty("webdriver.ie.driver", "./driver/ie.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.close();
		}

}
