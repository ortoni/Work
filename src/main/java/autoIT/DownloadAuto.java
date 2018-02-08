package autoIT;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DownloadAuto {
	@Test
	public void auto() throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver
		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://files.fm/");
		driver.findElementByXPath("(//input[@type='file'])[2]").click();
		// AutoIt
		Runtime.getRuntime().exec("./resource/a.exe"); // File path in a.au3 must be changed before executing

		
	}

}