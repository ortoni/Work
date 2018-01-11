package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Filessm {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./driver/gecko.exe");	// Initializing Chrome driver

		FirefoxDriver driver = new FirefoxDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://files.fm/");
		driver.findElementByXPath("(//input[@type='file'])[2]").sendKeys("C:\\Users\\TestLeaf\\Desktop\\koushik\\final.rar");
	}

}
